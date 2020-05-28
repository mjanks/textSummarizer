package textSummarizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<String> wordList = new ArrayList<String>();
		ArrayList<String> stopWordList = new ArrayList<String>();
		ArrayList<String> wordListStopsRemoved = new ArrayList<String>();
	    File file = new File("easywords.txt"); 
	    File file2 = new File("stopwords.txt");
	    Scanner scan = new Scanner(file);
	    Scanner scan2 = new Scanner(file2);
	    Summarizer s = new Summarizer();
	    
	    while(scan.hasNext()) {
	    	wordList.add(scan.next().toLowerCase());
	    }
	    
	    while(scan2.hasNext()) {
	    	stopWordList.add(scan2.next().toLowerCase());
	    }
	    
	    wordListStopsRemoved = s.removeStopWords(wordList, stopWordList);
	    
	    for(int i=0; i < wordList.size(); i++) {
	    	System.out.print(wordList.get(i) + " ");
	    }
	    System.out.println();
	    for(int i=0; i < wordListStopsRemoved.size(); i++) {
	    	System.out.print(wordListStopsRemoved.get(i) + " ");
	    }
	    
	    scan.close();
	    scan2.close();
	  
	  }
	}