/**
 * File: PQHeap.java
 * Author: Yusheng Hu
 * Date: 11/27/2016
 */

import java.util.ArrayList;
import java.util.Comparator;



public class PQHeap<T>{
	private ArrayList<T> heap;
	private int size;
	private Comparator<T> comp;
	
	public PQHeap( Comparator<T> comparator){
	// a constructor that initialized the empty heap, sets the size to zero, and stores the comparator.	
		comp = comparator;
		heap = new ArrayList<T>();
		size = 0;
	}
	
	public int getSize(){
	// return the number of elements in the heap.	
		return this.size;
	}
	
	public void print(){
		int time = 10;
		while(size>0&&time>0){
			System.out.println(remove());
			time--;
		}
	}
	
	//Utility function to swap two elements in the array list.
    public void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
    
    //Used in the add method
    public void moveup(){
    	int cur = this.size;
    	int par = (cur-1)/2;
    	
    	if (cur != 0){
			//if the child is bigger than the parent then swap position
			while (comp.compare(heap.get(cur), heap.get(par)) > 0){
				this.swap(cur, par);
				cur = par;
				par = (cur-1)/2;
			}
		}
    
    }
    //Use in the remove method
    public void movedown(){
    	int par = 0;
    	int childa = par*2 + 1;
    	int childb =(par+1) * 2;
    	while(childb < this.size){
    		//first figure out which child is the bigger one.
    		//Then compare the bigger child to the parent, if child is bigger, swap position
    		if (comp.compare(heap.get(childa), heap.get(childb)) > 0){
				if(comp.compare(heap.get(childa), heap.get(par)) > 0){	
					this.swap(childa, par);
					par = childa;
					childa = par*2 + 1;
					childb =(par+1) * 2;
				}
				else{
					break;
				}
    		}
    		
    		else if (comp.compare(heap.get(childb), heap.get(par)) > 0){
    			this.swap(childb, par);
				par = childb;
				childa = par*2 + 1;
				childb =(par+1) * 2;
    			}    		
    			else break;  	
    	}
    	
    }
    
    
	//
	public void add(T obj){	
			heap.add(obj);
			this.moveup();
			size++;
	}
	
	public T remove(){		
		// if there is nothing in the arraylist, then return null 
		if (this.size == 0){
			return null;
		}
		//if there is only one element, then return the root;
		else if (this.size == 1){
			T root = heap.get(0);
			heap.remove(size-1);
			size--;
			return root;
		}
		//store the root
		//swap the position of the last element and the root node. 
		//then call movedown method to make the heap into a good order
		//then remove the last element of the heap
		//return root
		else{	
			T root = heap.get(0);
			this.swap(0, this.size - 1);
			this.movedown();
			heap.remove(this.size - 1);
			size--;
			return root;
		}
	
	}
}

