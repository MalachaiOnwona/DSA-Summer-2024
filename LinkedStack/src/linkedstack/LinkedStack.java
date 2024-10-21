/**
 * 
 */
package linkedstack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Malachai Onwona
 *
 */
public class LinkedStack<Item> implements Iterable<Item> {
	
	private Node first;
	private int size;
	
	public LinkedStack() {
		
		first = null;
		size = 0;
		
	}
	
	
	private class Node{
		
		Item item;
		Node next;
		
		public Node() {
			
		}
		
	}
	
	
	public void push(Item item) {
		
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		
	}
	
	public Item pop() {
		
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		
		Item removed = first.item;
		first = first.next;
		size--;
		
		return removed;
		
	}
	
	/**
	 * Returns but does not remove
	 * the item at the top of the
	 * stack
	 * 
	 * @return
	 * 		The item at the top of
	 * 		the stack
	 */
	
	public Item peek() {
		
		if (isEmpty()) throw new NoSuchElementException("Stack underflow");
		
		return first.item;
		
	}
	
	public boolean isEmpty() {
		
		return first == null;
		
	}
	
	public int size() {
		
		return size;
		
	}

	@Override
	public Iterator<Item> iterator() {
		
		return new LinkedListIterator();
		
	}
	
	private class LinkedListIterator implements Iterator<Item>{
		
		private Node current = first;
		
		public LinkedListIterator() {
			
		}
		
		public boolean hasNext() {
			
			return current != null;
			
		}
		
		public Item next() {
			
			if (!hasNext())throw new NoSuchElementException();
			
			Item item = current.item;
			current = current.next;
			
			return item;
			
		}
	}

}
