package textSummarizer;

import java.util.ArrayList;

public class Summarizer {

	public ArrayList<String> removeStopWords(ArrayList<String> list, ArrayList<String> stopWords) {
		ArrayList<String> newList = new ArrayList<String>();
		for(int i=0; i < list.size(); i++) {
			for(int j=0; j < stopWords.size(); j++) {
				if(list.get(i).equals(stopWords.get(j))) {
					System.out.println("mathced stopword: " + stopWords.get(j));
					i++;
					j = 0;
				} 
				
			}
			newList.add(list.get(i));
		}
		return newList;
	}

}
