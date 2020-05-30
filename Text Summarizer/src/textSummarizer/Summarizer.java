package textSummarizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Summarizer {

	public ArrayList<String> removeStopWords(String list, ArrayList<String> stopWords) {
		ArrayList<String> newList = new ArrayList<String>();
		String delims = "[,;:\" ]+";
	    String[] tokens = list.split(delims);
		for(int i=0; i < tokens.length; i++) {
			for(int j=0; j < stopWords.size(); j++) { // indexOutOfBounds Exception when stop word is the last word in a doc
				if((tokens[i].equals(stopWords.get(j)))) {
					System.out.println("mathced stopword: " + stopWords.get(j));
					
					if (i != tokens.length - 1) {
						i++;
					} else {
						return newList;
					}
				} 
				
			}
			
			if(!"".equals(tokens[i])) {
				newList.add(tokens[i]);
			}
			
		}
		return newList;
	}
	
	public static void countFrequencies(ArrayList<String> list) 
    { 
        // hashmap to store the frequency of element 
        Map<String, Integer> hm = new HashMap<String, Integer>(); 
  
        for (String i : list) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        } 
  
        // displaying the occurrence of elements in the arraylist 
        for (Map.Entry<String, Integer> val : hm.entrySet()) { 
            System.out.println("Element " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times"); 
        } 
    } 
	
	public ArrayList<String> removeDuplicates(ArrayList<String> list) {
		Set<String> listWithoutDuplicates = new LinkedHashSet<String>(list);
		list.clear();
		list.addAll(listWithoutDuplicates);
		return list;
	}

}
