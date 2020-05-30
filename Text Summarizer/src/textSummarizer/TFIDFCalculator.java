package textSummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TFIDFCalculator extends Summarizer {
	
	public Map<String, Double> calcNTF(ArrayList<String> list) {
		Map<String, Double> NTFHashMap = new HashMap<String, Double>();
		Map<String, Double> wordFrequencyHashMap = new HashMap<String, Double>();
		double highest = 0.0;
		double temp = 0.0;
		
		wordFrequencyHashMap = countFrequencies(list);
		
		for (Map.Entry<String, Double> val : wordFrequencyHashMap.entrySet()) {
			temp = val.getValue();
			if(temp > highest) {
				highest = temp;
			}
		}
		System.out.println("Highest: " + highest);
		
		for (Map.Entry<String, Double> val : wordFrequencyHashMap.entrySet()) {
			NTFHashMap.put(val.getKey(), (val.getValue()/highest));
			System.out.println("key: " + val.getKey() + " NTF: " + (val.getValue()/highest));
		}
		return NTFHashMap;
	}
	

/**
 * @author Mohamed Guendouz
 */
    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }

    /*public static void main(String[] args) {

        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);

        TFIDFCalculator calculator = new TFIDFCalculator();
        double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
        System.out.println("TF-IDF (ipsum) = " + tfidf);


    }*/


}