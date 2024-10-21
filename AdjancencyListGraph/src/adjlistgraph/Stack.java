/**
 * 
 */
package adjlistgraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Malachai Onwona
 *
 */
public class Stack<Item> implements Iterable<Item> {
	
	private Node<Item> first;
	private int size;
	
	public Stack() {
		
		first = null;
		size = 0;
		
	}
	
	
	private class Node<Item>{
		
		Item item;
		Node<Item> next;
		
		public Node() {
			
		}
		
	}
	
	
	public void push(Item item) {
		
		Node<Item> oldFirst = first;
		first = new Node<Item>();
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
		
		return new LinkedIterator(first);
		
	}
	
	private class LinkedIterator implements Iterator<Item>{
		
		private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
        	
            current = first;
            
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

