/**
 * 
 */
package resizearraystack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Malachai Onwona
 *
 */
public class ResizingArrayStack<Item> {
	
	private Item[] items;
	private static final int INIT_CAPACITY = 8;
	private int size;
	
	public ResizingArrayStack() {
		
		items = (Item[]) new Comparable[INIT_CAPACITY];
		size = 0;
		
	}
	
	
	public void resize(int amount) {
		
		Item[] temp = (Item[]) new Comparable[amount];
		
		for (int i = 0; i < size; i++) {
			
			temp[i] = items[i];
			
		}
		
		items = temp;
		
	}
	
	public void push(Item item) {
		
		if (size == items.length) resize(2*items.length);
		
		items[size++] = item;
		
	}
	
	public Item pop() {
		
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		
		Item removed = items[size-1];
		items[size-1] = null;
		size--;
		
		if (size > 0 && size == items.length/4) resize(items.length/2);
		
		return removed;
		
	}
	
	public boolean isEmpty() {
		
		return size == 0;
		
	}
	
	public int size() {
		
		return size;
		
	}
	
	public Iterator<Item> reverseOrder(){
		
		return new ReverseArrayIterator();
		
	}
	
	
	private class ReverseArrayIterator implements Iterator<Item>{
		
		private int index;
		
		public ReverseArrayIterator() {
			
			index = size - 1;
			
		}
		
		public boolean hasNext() {
			
			return index >= 0;
			
		}
		
		public Item next() {
			
			if (!hasNext()) throw new NoSuchElementException();
			
			return items[index--];
			
		}
		
	}
	
	
	public static void main(String[] args) {  //To be implemented
		
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
	}

}
