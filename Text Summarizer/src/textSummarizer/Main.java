package textSummarizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> stopWordList = new ArrayList<String>();
		ArrayList<String> wordListStopsRemoved = new ArrayList<String>();
		ArrayList<String> masterWordList = new ArrayList<String>();
		Map<String, Double> docFreqHashMap = new HashMap<String, Double>();
		Map<String, Double> IDFHashMap = new HashMap<String, Double>();
		Map<String, Double> NTFHashMap = new HashMap<String, Double>();
	    File file = new File("easywords.txt"); 
	    File file2 = new File("stopwords.txt");
	    String str = "";
	    Scanner scan = new Scanner(file);
	    Scanner scan2 = new Scanner(file2);
	    Summarizer s = new Summarizer();
	    TFIDFCalculator calc = new TFIDFCalculator();
	    int totDocs = 0;  // total number of docs
	    double numDocsWordIsIn = 0;
	    
	    while(scan.hasNext()) {
	    	str = str.concat(scan.next() + " ");
	    }
	    
	    String delims = "[.?!]";
	    String[] tokens = str.split(delims);
	    
	    
	    while(scan2.hasNext()) {
	    	stopWordList.add(scan2.next().toLowerCase());
	    }
	    
	    for(int i=0; i < tokens.length; i++) {
	    	if(!tokens[i].equals(" ")) {
	    		System.out.println();
		    	System.out.println("Token " + i + ": " + tokens[i]);
		    	wordListStopsRemoved = s.removeStopWords(tokens[i].toString().toLowerCase(), stopWordList);
			    System.out.print("After stops removed (size: " + wordListStopsRemoved.size() + "): " + wordListStopsRemoved);
			    System.out.println();
			    calc.calcNTF(wordListStopsRemoved);
			    System.out.println("After duplicates and stops removed (size: " + 
			    		s.removeDuplicates(wordListStopsRemoved).size() + "): " + 
			    		s.removeDuplicates(wordListStopsRemoved));
			    for(int j=0; j < s.removeDuplicates(wordListStopsRemoved).size(); j++) {
			    	masterWordList.add(s.removeDuplicates(wordListStopsRemoved).get(j));
			    }
			    totDocs++;
	    	}
	    }
	    
	    System.out.println();
	    System.out.println("Total number of documents: " + totDocs);
	    
	    System.out.print("Master word list before remove duplicates (size: " + masterWordList.size() + "): ");
	    for(String word : masterWordList) {
	    	System.out.print(word + " ");
	    }
	    
	    System.out.println();
	    masterWordList = s.removeDuplicates(masterWordList);
	    System.out.print("Master word list after remove duplicates (size: " + masterWordList.size() + "): ");
	    for(String word : masterWordList) {
	    	System.out.print(word + " ");
	    }
	    
	    System.out.println();
	    System.out.println("tokens.length: " + tokens.length);
	    
	    
	    for(int i=0; i < masterWordList.size(); i++) {
	    	for(int j=0; j < tokens.length; j++) {
	    		if(!tokens[j].equals(" ")) {
	    			wordListStopsRemoved = s.removeStopWords(tokens[j].toString().toLowerCase(), stopWordList);
	    			wordListStopsRemoved = s.removeDuplicates(wordListStopsRemoved);
	    			for(int k=0; k < wordListStopsRemoved.size(); k++) {
	    				if(masterWordList.get(i).equals(wordListStopsRemoved.get(k))) {
		    				numDocsWordIsIn++;
		    			}
	    			}
	    		}
	    	}
	    	docFreqHashMap.put(masterWordList.get(i), numDocsWordIsIn);
	    	System.out.println(masterWordList.get(i) + " appears in " + numDocsWordIsIn + " docs.");
	    	numDocsWordIsIn = 0;
	    }
	    for(int i=0; i < tokens.length; i++) {
	    	if(!tokens[i].equals(" ")) {
		    	wordListStopsRemoved = s.removeStopWords(tokens[i].toString().toLowerCase(), stopWordList);
				wordListStopsRemoved = s.removeDuplicates(wordListStopsRemoved);
				NTFHashMap = calc.calcNTF(wordListStopsRemoved);
		    	IDFHashMap = calc.calcIDF(totDocs, docFreqHashMap);
	    	}
	    }
	    
	    
	    scan.close();
	    scan2.close();
	  
	  }
	}