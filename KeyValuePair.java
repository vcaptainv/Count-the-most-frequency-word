/**
 * File: BSTMap.java
 * Author: Yusheng Hu
 * Date: 11/01/2016
 */
 
public class KeyValuePair<Key, Value>{
	private Key key;
	private Value value;
	//Constructor method
	public KeyValuePair(Key k, Value v){
		
		this.key=k;
		this.value=v;
	
	}
	//Returns the key out
	public Key getKey(){
	
		return this.key;
	
	}
	//Return the value out
	public Value getValue(){
	
		return this.value;
	
	}
	//set a new value
	public void setValue(Value v){
		this.value= v;
	}
	//print the keyvaluepair out.
	public String toString(){
		String a= "";
		a+=this.key;
		a+=" ";
		a+=this.value;
		return a;
	
	}
	
	 public static void main( String[] args ) {
	 	KeyValuePair<String, Integer> key = new KeyValuePair<String, Integer>( "CAT",  5);
	 	System.out.println(key.getKey());
	 	System.out.println(key.getValue());
	 	key.setValue(6);
	 	System.out.println(key.getValue());
	 }
}