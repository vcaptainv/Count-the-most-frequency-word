/**
 * File: FindCommonWords.java
 * Author: Yusheng Hu
 * Date: 11/27/2016
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;

 public class FindCommonWords{
 	//Store three fields, the comparator, PQHeap, and a word counter.
 	private PQHeap<KeyValuePair<String,Integer>> pq;
 	private WordCounter wc;
 	private Comparator<KeyValuePair<String,Integer>> comp;
 	
 	//Initiate all the fields.
 	public FindCommonWords(Comparator<KeyValuePair<String,Integer>> comparator){
 		wc = new WordCounter();
 		comp = comparator;
 		pq = new PQHeap<KeyValuePair<String,Integer>>(comparator);
 	}
 	
 	//Main function 
 	public static void main( String[] args ) throws IOException{
 		
 		FindCommonWords fcw = new FindCommonWords(new KVTestComparator());

 		fcw.wc.readWordCountFile(args[0]);
 		//Use getPairs to return every key-value pair in the bst map to an arraylist
 		ArrayList<KeyValuePair<String,Integer>> pair = fcw.wc.getPairs();
 		//Add every elements in the list to the pqheap
 		for (KeyValuePair<String, Integer> item: pair){
 			///////////////////MEMORY LOST(item) each loop//////////////////////
 			fcw.pq.add(item);
 		}
 		//call print method to print top ten frequent words
 		fcw.pq.print();
 		
 		
 		
 	}
 
 }
 
 
 //Comparator.
 class KVTestComparator implements Comparator<KeyValuePair<String,Integer>> {
    public int compare( KeyValuePair<String,Integer> i1, KeyValuePair<String,Integer> i2 ) {
        int diff = i1.getValue() - i2.getValue();
        if (diff == 0)
            return 0;
        if (diff < 0)
            return -1;
        else
            return 1;
    }
}