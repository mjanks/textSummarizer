package textSummarizer;

import java.io.File; 
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// pass the path to the file as a parameter 
	    File file = 
	      new File("test.txt"); 
	    Scanner sc = new Scanner(file); 
	  
	    while (sc.hasNextLine()) 
	      System.out.println(sc.nextLine()); 
	  }
	}