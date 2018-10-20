/**
 * File: BSTMap.java
 * Author: Yusheng Hu
 * Date: 11/01/2016
 */

import java.util.ArrayList;
import java.util.Comparator;

public class BSTMap<K,V> implements MyMap<K,V> {
	//Stores the root, the comparator, the size of the BSTMap and the depth of the BSTMap
    private TreeNode<K,V> root;
    private Comparator<K> comparator;
    private int size;
    private int depth=0;
    
    //Constructor method
    public BSTMap(Comparator<K> comparator ) {
        this.comparator = comparator;
        this.root=null;
        // WARNING: THIS CODE IS INCOMPLETE. You still need to initialize the root.
        // and code that initializes root
    }
    
    //put a node inside the BSTMap
    // Call the TreeNode's put method. It will need the comparator passed in to it.
    public void put( K key, V value ) {
		if (root==null){
			TreeNode<K, V> n= new TreeNode<K, V>(key, value, null, null);
			root=n;	
			size++;
		}
		else{
			//the put method will return a number(shown below in the tree node).
			size+=root.put(key, value, comparator);
		}
	        
    }
   
   //test if the map contains the key.
	public boolean containsKey(K key){
    	return root.contain(key, this.comparator);
    
    }
    
    //No meaning(since this function is never used)
    public ArrayList<K> getKeys(){
    	return null;
    
    }
    //return the size of the BSTMap
    public int size(){
    	return this.size;
    
    }
    //pre-order print 
    public void printInOrder(){
    	root.toString();
    }
    
    //return the value of the node under a given key
    public V get(K key){
    	if (root==null){return null;}
    	return root.get( key, this.comparator);
    }
    
    //Return an arraylist of keyvaluepair
    public ArrayList<KeyValuePair<K,V>> getPairs(){
        ArrayList<KeyValuePair<K,V>> a = new ArrayList<KeyValuePair<K,V>>();
		//System.out.println("test in BST MAP class getpair method "+root.getPairs());
		root.getPairs(a);
    	return a;
    }
   
    //Main function (I use BSTMap to test it.)
    public static void main( String[] args ) {
        System.out.println( "test code" );
        BSTMap<String,Integer> map = new BSTMap<String,Integer>(new AscendingStringComparator());
        map.put( "B", 2 );
        map.put( "A", 1);
        map.put( "D", 2 );
        map.put( "C", 2 );
        map.printInOrder();
        System.out.println();
        System.out.println( "Has B: " + map.containsKey( "B" ) );
        System.out.println( "Has A: " + map.containsKey( "A" ) );
        System.out.println( "Has G: " + map.containsKey( "G" ) );
        map.put( "D", 3 );
        System.out.println( "D now has value " + map.get( "D" ) );
        System.out.println( "The tree has " + map.size() + " elements" );
       // System.out.println( "The tree has " + map.depth() + " levels" );
        ArrayList<KeyValuePair<String,Integer>> pairs  = map.getPairs();
        System.out.println( "In useful order: " );
        System.out.println( pairs );
    }        
}

//---------------------------------------
class TreeNode<Key,Value> {
   	//Store the current key value pair and its left node and right node.
    private KeyValuePair<Key,Value> pair;
    private TreeNode<Key,Value> left;
    private TreeNode<Key,Value> right;
	
	//Constructor method
    public TreeNode( Key this_key, Value this_val, TreeNode<Key,Value> l, TreeNode<Key,Value> r ) {
        this.pair= new KeyValuePair<Key, Value>(this_key, this_val) ; // code here
        this.left=l;
        this.right= r;
    }
    
    //Tree Node put function
    // return 1 if successfully add the node in the bst map
    // return 0 if just update the value of key in the BSTMap
    public int put( Key key, Value value , Comparator<Key> comparator){
    	//given key is smaller than the key of root
    	if (comparator.compare(key, pair.getKey())<0){
			if (left==null){
				TreeNode<Key, Value>pp= new TreeNode<Key, Value>(key, value, null, null);
				left=pp; //////////Memory Lost!!!!!!!
				return 1;
				}
			else{
				//if left is not null, then pass the function to the left child.
				return left.put(key, value, comparator);
			}

    	}
    	//given key is bigger than the key of root
    	else if (comparator.compare(key, pair.getKey())>0){
			if (right==null){
				TreeNode<Key, Value>pp= new TreeNode<Key, Value>(key, value, null, null);
				right=pp;  //////////Memory Lost!!!!!!!
				//successful add a new node in the BSTMap
				return 1;
				}
			else{
				//if right is not null, then pass the function to the left child.
				return right.put(key, value, comparator);
			}
    	}
    	else{
    		pair.setValue(value);
    		//System.out.println("update"+key);
    		return 0;
    	}
    }
    //test if the bst map contain the key.
    public boolean contain(Key k, Comparator<Key> comparator){
    	if (comparator.compare(k, pair.getKey())==0){
    		return true;
    		
    	}
    	else if (comparator.compare(k, pair.getKey())<0){
    		if (left!=null){
				return left.contain(k,comparator);
			}
		}
		else if(comparator.compare(k, pair.getKey())>0){
			if (right!=null){
    			return right.contain(k,comparator);  
    		}  		
    	}
    	return false;

    }
    
    //Get the value of the key
    //if bst map contains the key, then return the value
    public Value get(Key k,	Comparator<Key> comparator){
    	
		if (comparator.compare(k, pair.getKey())<0){
			if (left != null){
				return left.get(k,comparator);
			}
			else{
				return null;
			}
			
		}
		else if(comparator.compare(k, pair.getKey())>0){
			if (right !=null){
				return right.get(k, comparator);
			}
			else{
				return null;
			}
		}
		else {
		   	return this.pair.getValue();
    	}
    	
    	
    }
    // print the tree node
    public String toString(){
    	if (this.left!= null){
			left.toString();
		}
    	String a = "( ";
    	
    	a+=this.pair.getKey();
    	a+=", ";
    	a+=this.pair.getValue();
    	a+=")";
		System.out.println(a);
    	if(this.right!= null){
    		right.toString();
    	}
    	
    	return null;
    }
    
    // getpairs function.
    public KeyValuePair<Key,Value> getPairs(ArrayList<KeyValuePair<Key,Value>> a){
		a.add(this.pair);
		
		if (left!=null){
			left.getPairs(a);
		}
		if (right!=null){
			right.getPairs(a);  
		}  	
    	return this.pair;
    }

} // end class TreeNode

class AscendingStringComparator implements Comparator<String> {
    public int compare( String i1, String i2 ) {
        // returns negative number if i2 comes after i1 lexicographically
        return i1.compareTo(i2);
    }
}