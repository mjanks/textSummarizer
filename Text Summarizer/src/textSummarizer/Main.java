package textSummarizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> stopWordList = new ArrayList<String>();
		ArrayList<String> wordListStopsRemoved = new ArrayList<String>();
		ArrayList<String> masterWordList = new ArrayList<String>();
		//List<String> list = null;
		//List<List<String>> list2 = null;
		//String term = "dog";
	    File file = new File("easywords.txt"); 
	    File file2 = new File("stopwords.txt");
	    String str = "";
	    Scanner scan = new Scanner(file);
	    Scanner scan2 = new Scanner(file2);
	    Summarizer s = new Summarizer();
	    TFIDFCalculator calc = new TFIDFCalculator();
	    int n = 0;  // total number of docs to process
	    
	    while(scan.hasNext()) {
	    	str = str.concat(scan.next() + " ");
	    }
	    
	    String delims = "[.?!]";
	    String[] tokens = str.split(delims);
	    
	    /*for (int i = 0; i < tokens.length; i++) {
	        list = Arrays.asList(tokens);
	        list2 = Arrays.asList(list);
	    }
	    System.out.println("list2: " + list2);
	    */
	    
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
			    n++;
	    	}
	    }
	    System.out.println();
	    System.out.println("Total number of documents: " + n);
	    
	    System.out.print("Master word list before remove duplicates: ");
	    for(String word : masterWordList) {
	    	System.out.print(word + " ");
	    }
	    
	    System.out.println();
	    System.out.print("Master word list after remove duplicates: ");
	    masterWordList = s.removeDuplicates(masterWordList);
	    for(String word : masterWordList) {
	    	System.out.print(word + " ");
	    }
	    
	    scan.close();
	    scan2.close();
	  
	  }
	}