package textSummarizer;

import java.util.ArrayList;

public class Summarizer {

	public ArrayList<String> removeStopWords(String list, ArrayList<String> stopWords) {
		ArrayList<String> newList = new ArrayList<String>();
		String delims = "[ ]+";
	    String[] tokens = list.split(delims);
		for(int i=0; i < tokens.length; i++) {
			for(int j=0; j < stopWords.size(); j++) {
				if((tokens[i].equals(stopWords.get(j)))) {
					System.out.println("mathced stopword: " + stopWords.get(j));
					i++;
					j = 0;
				} 
				
			}
			newList.add(tokens[i]);
		}
		return newList;
	}

}
