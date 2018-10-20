/**
 * File: FindTrends.java
 * Author: Yusheng Hu
 * Date: 11/28/2016
 */
 
import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
 
 
 public class FindTrends{
 	private WordCounter wc;
 	
 	public FindTrends(Comparator<KeyValuePair<String,Integer>> comparator){
 		wc = new WordCounter();
 		comp = comparator;
 	}
 	
 	public static void main( String[] args ) throws IOException{
 		System.out.println(args.length);
 		
 		WordCounter wc = new WordCounter();
		ArrayList<String> string = new ArrayList<String>();
 		
 		int beginyear = Integer.parseInt(args[1]);
 		int endyear = Integer.parseInt(args[2]);
 		
 		//System.out.println(beginyear);
 		//System.out.println(endyear);
 		
 		for (int i = 3; i < args.length; i++){
 			string.add(args[i]);
 		}
 		double [][] a = new double[endyear-beginyear+1][args.length - 2];
 		
 		int year = 0;
 		
 		for (int j = 0; j < endyear - beginyear + 1; j++){
 			for (int c = 0; c < string.size(); c++){
 				year = beginyear + j;
 				wc.readWordCountFile(args[0] + year + ".txt");
 				
 				//System.out.println("total "+ wc.getTotalWordCount());
 				//System.out.println("word " + wc.getCount(string.get(c)));
 				a[j][c] = wc.getFrequency(string.get(c));
 			}
 			wc.clear();///////////////////MEMORY LOST at each loop//////////////////////
 		}
 		
 		String print = "";
 		for (int o = 0; o < string.size(); o++){
 			
 			for (int p= 0; p < endyear-beginyear+1; p++){
 				if (p == 0){
 					print += string.get(o) + " ";
 				}
 				print += a[p][o] + " ";
 			}
 			System.out.println(print);
 			print = "";
 		}
 	}
}