package textSummarizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Summarizer {

	public ArrayList<String> removeStopWords(String list, ArrayList<String> stopWords) {
		ArrayList<String> newList = new ArrayList<String>();
		boolean flag = false;
		String delims = "[,;:\"\\[\\]()\\- ]+";
	    String[] tokens = list.split(delims);
		for(int i=0; i < tokens.length; i++) {
			for(int j=0; j < stopWords.size(); j++) {
				if((tokens[i].equals(stopWords.get(j)))) {
					//System.out.println("matched stopword: " + stopWords.get(j));
					flag = true;
					if (i == tokens.length - 1) {
						return newList;
					}
				} 
			}
			if(!"".equals(tokens[i]) && flag == false) {
				newList.add(tokens[i]);
			} else {
				flag = false;
			}
			
		}
		return newList;
	}
	
	public Map countFrequencies(ArrayList<String> list) 
    { 
        // hashmap to store the frequency of element 
        Map<String, Double> hm = new HashMap<String, Double>(); 
  
        for (String i : list) { 
            Double j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        } 
  
        // displaying the occurrence of elements in the arraylist 
        /*for (Map.Entry<String, Double> val : hm.entrySet()) { 
            System.out.println("Element " + val.getKey() + " "
                               + "occurs"
                               + ": " + val.getValue() + " times"); 
        } 
        */
        return hm;
    } 
	
	public ArrayList<String> removeDuplicates(ArrayList<String> list) {
		Set<String> listWithoutDuplicates = new LinkedHashSet<String>(list);
		list.clear();
		list.addAll(listWithoutDuplicates);
		return list;
	}
}
