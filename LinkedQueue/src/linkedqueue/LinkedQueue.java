/**
 * 
 */
package linkedqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Malachai Onwona
 *
 */
public class LinkedQueue<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size;
	
	public LinkedQueue() {
		
		first = null;
		last = null;
		size = 0;
		
	}
	
	
	private class Node{
		
		Item item;
		Node next;
		
		public Node() {
			
		}
		
	}
	
	
	public void enqueue(Item item) {
		
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if (isEmpty()) first = last;
		
		else oldLast.next = last;
		
		size++;
		
	}
	
	public Item dequeue() {
		
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		
		Item removed = first.item;
		first = first.next;
		size--;
		
		if (isEmpty()) last = null;
		
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
		
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		
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
