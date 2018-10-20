/**
 * File: WordCounter.java
 * Author: Yusheng Hu
 * Date: 11/01/2016
 */
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.ArrayList;

//Instruction
// generate a BSTMap from a text document. To do so, it will read in the text, separate it into words.
//For each word, it should check to see if the word is a key in the BSTMap.
// If it isn't, then add the Key-Value pair to the dictionary with the word as the key and 1 as the value. 
//If it is, then increment the value associated with that word.
// write a file containing the values of the dictionary, with the total number of words on the first line, 
//and each word and its count on the subsequent lines (one pair per line). 
//We will refer to a file formatted like this as a word count file.
// read a word count file, recreating the BSTMap.
// Implement accessor methods for the dictionary.



 public class WordCounter{
 	// store a BST map and the total word count
 	private BSTMap<String,Integer> map;
 	private BSTMap<String,Integer> ignoremap;
 	private int count;
 	private int unicount;
 	
 	// constructor
 	public WordCounter(){
 		map = new BSTMap<String,Integer>(new AscendingStringComparator());
 		ignoremap = new BSTMap<String,Integer>(new AscendingStringComparator());
 		count = 0;
 		unicount = 0;
 	}
 	
 	//Return an arraylist of keyvaluepair
    public ArrayList<KeyValuePair<String,Integer>> getPairs(){
    	return map.getPairs();
    }
 	
 	public void clear(){
 	// reset the bst map
 		map = new BSTMap<String,Integer>(new AscendingStringComparator());
 		count = 0;
 		unicount = 0;
 	}
 	
 	
 	//Extension 1
 	public void ignore() throws IOException{
 		BufferedReader br = new BufferedReader(new FileReader("common.txt"));
 		///////////////////MEMORY LOST at the end the function//////////////////
 		String test = br.readLine();
 		///////////////////MEMORY LOST EACH LOOP//////////////////
 		String line = "";
 		while (test != null) {
    		line = test;
    		
    		String[] parse = line.split(" ");// Regular expressions!
    		///////////////////MEMORY LOST EACH LOOP//////////////////
			for (int i = 0; i < parse.length; i++) {
				String word = parse[i].trim().toLowerCase();
				if (word == " "){break;}
				if (word.length() != 0){
					//Since in common.txt all the words only appear once.
					ignoremap.put(word, 1);
					//System.out.println("yes");
				}
			}
			test = br.readLine(); 
		}	
 	}
 	
 	//loadFromOriginalWordsFile can load a new file and convert it to a new BSTmap
 	public void loadFromOriginalWordsFile( String filename ) throws IOException{
 		BufferedReader br = new BufferedReader(new FileReader(filename));
 		String test = br.readLine();
 		///////////////////MEMORY LOST EACH LOOP//////////////////
 		String line = "";
 		while (test != null) {
    		line = test;
    		//line += " ";
    		String[] parse = line.split("[^a-zA-Z']");// Regular expressions!
			///////////////////MEMORY LOST EACH LOOP//////////////////
			//System.out.println("after while");
			
			// split line into words. Any character other than a letter (a-z and A-Z) or a single quote
			// is considered a non-word character and is used to split words.
			// You may want to include numbers in the list of characters that are consider 
			// parts of words.
			for (int i = 0; i < parse.length; i++) {
				String word = parse[i].trim().toLowerCase();  ///////////////////MEMORY LOST//////////////////////
				if (word == " "){break;}
				if (word.length() != 0){
				//System.out.println(word);
				//test if the map contains the word if yes, the update the value,
				//if not then add a new key in the map
					if (ignoremap.get(word) == null){
						if (map.get(word) == null){
							map.put(word, 1);
							this.count ++;
						}
						else{
							map.put(word, map.get(word) + 1);
							this.count ++;
						}
					}
				}
			}
    		
    		test = br.readLine();
		} 
		
 		
       
 	 }
 	 
 	 
 	 //return the word count 
 	 public int getTotalWordCount(){
 	 	return this.count;
 	 }
 	 //return the value of a word
 	 public int getCount( String word ){
 	 	if (map.get(word) == null){
 	 		return 0;
 	 	}
 	 	else{
 	 		return this.map.get(word);
 	 	}
 	 }
 	 
 	 //return the frequency of a word.
 	 public float getFrequency( String word ){
 	 	if (map.get(word)==null){
 	 		return 0;
 	 	}
 	 	else{
			float fre;
			fre = (float)getCount(word)/getTotalWordCount();
			// System.out.println(getTotalWordCount()+"test at getfre");
			return fre;
		}
 	 }
 	 
 	 //writeWordCountFile write the contents of the fields to a word count file.
 	 public void writeWordCountFile( String filename ) throws IOException{
	 	//System.out.println("total_word_count : " + getTotalWordCount() + "\n");
	 	//I use printwriter package to write the new file
	 	PrintWriter PrintWriter = new PrintWriter(filename);
	 	///////////////////MEMORY LOST at the end the function//////////////////
	 	ArrayList<KeyValuePair<String, Integer>> line = map.getPairs();
	 	///////////////////MEMORY LOST at the end the function//////////////////
	 	
	 	//System.out.println("unique_word_count : "+ this.map.size());
	 	for (KeyValuePair<String, Integer> item: line){
	 		///////////////////MEMORY LOST//////////////////////
	 		
	 		///////////////////Task 3/////////////////
	 		//If you want to test the short.txt, you can uncomment the following line
	 		//If you are runing the reddit comment, please comment this following line
	 		//System.out.println(item.getKey() + " " + getCount(item.getKey()));
	 		PrintWriter.println(item.toString()); 		
	 	}
	 	
		PrintWriter.close();
	 	
	 }
	 
	 
	 // read the word count file
	 // read the contents of a word count file and reconstruct the fields of the WordCount object.
	 public void readWordCountFile(String filename) throws IOException{
	 	BufferedReader br = new BufferedReader(new FileReader(filename));
 		String test = "";
 		String line = "";
 		String key = "";
 		String value = "";
 		while ((test = br.readLine()) != null) {
    		line = test;///////////////////MEMORY LOST each loop//////////////////////    		
    		//split the string every time when encounter space
    		String[] parse = line.split(" "); ///////////////////MEMORY LOST each loop//////////////////////
    		value = parse[1];
    		key = parse[0];
    		this.count += Integer.valueOf(value);
    		//System.out.println(key);
    		//System.out.println(value);
    		
            map.put(key, Integer.valueOf(value));
		} 
		this.writeWordCountFile("redo_counts_short.txt");
	 }

	 public static void main( String[] args ) throws IOException{
	 	WordCounter wc = new WordCounter();
	 	
	 	///////////Extension 1!!!//////
	 	//uncomment it if you wan to test the first extension
	 	//wc.ignore();
	 	System.out.println("loading");
	 	wc.loadFromOriginalWordsFile(args[0]);
	 	System.out.println("writing");
	 	//wc.writeWordCountFile(args[1]);
	 	System.out.println(wc.getFrequency("is"));
	 	////////Task 4//////////
	 	//Uncomment it if you want to the forth task.
	 	//wc.readWordCountFile("counts_short.txt");
	 	//wc.writeWordCountFile(args[2]);
	 	
	 }
	 
	 
 }
 
 class AscendingIntegerComparator implements Comparator<Integer> {
    public int compare( Integer i1, Integer i2 ) {
        // returns negative number if i1 is greater than i2
        return i2-i1;
    }
}