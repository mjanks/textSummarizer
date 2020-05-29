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
		List<String> list = null;
		List<List<String>> list2 = null;
	    File file = new File("easywords.txt"); 
	    File file2 = new File("stopwords.txt");
	    Scanner scan = new Scanner(file);
	    Scanner scan2 = new Scanner(file2);
	    Summarizer s = new Summarizer();
	    String str = "";
	    
	    while(scan.hasNext()) {
	    	str = str.concat(scan.next() + " ");
	    }
	    System.out.println("str: " + str);
	    String delims = "[.?!]+";
	    String[] tokens = str.split(delims);
	    for (int i = 0; i < tokens.length; i++) {
	        System.out.println("Token " + i + ": " + tokens[i]);
	        list = Arrays.asList(tokens);
	        list2 = Arrays.asList(list);
	    }
	    System.out.println("list2: " + list2);
	    
	    while(scan2.hasNext()) {
	    	stopWordList.add(scan2.next().toLowerCase());
	    }
	    
	    wordListStopsRemoved = s.removeStopWords(tokens[0].toString().toLowerCase(), stopWordList);
	    // s.countFrequencies(wordListStopsRemoved);
	    
	    TFIDFCalculator calc = new TFIDFCalculator();
	    String term = "stop";
	    System.out.println(calc.tf(wordListStopsRemoved, term));
	    System.out.println(calc.idf(list2, term));
	    
	    System.out.println();
	    System.out.print("After stops removed: ");
	    for(int i=0; i < wordListStopsRemoved.size(); i++) {
	    	System.out.print(wordListStopsRemoved.get(i) + " ");
	    }
	    
	    scan.close();
	    scan2.close();
	  
	  }
	}