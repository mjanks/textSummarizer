package textSummarizer;

import java.util.ArrayList;
import java.util.HashMap;
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
		//System.out.println("Highest: " + highest);
		
		for (Map.Entry<String, Double> val : wordFrequencyHashMap.entrySet()) {
			NTFHashMap.put(val.getKey(), (val.getValue()/highest));
			//System.out.println("key: " + val.getKey() + " NTF: " + (val.getValue()/highest));
		}
		return NTFHashMap;
	}
	
	public Map<String, Double> calcIDF(int totDocs, Map<String, Double> termFreq) {
		Map<String, Double> IDFHashMap = new HashMap<String, Double>();
		double IDF = 0.0;
		for(Map.Entry<String, Double> val : termFreq.entrySet()) {
			IDF = (Math.log(totDocs/val.getValue()) / Math.log(2)) + 1;
			IDFHashMap.put(val.getKey(), IDF);
			//System.out.println("key: " + val.getKey() + " IDF: " + IDF);
		}
		// This calculation is for a global IDF
		return IDFHashMap;
	}
}