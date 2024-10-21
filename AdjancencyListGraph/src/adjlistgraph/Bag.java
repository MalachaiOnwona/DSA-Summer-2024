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
public class Bag<Item> implements Iterable<Item> {
	
    private Node<Item> first;    
    private int n;               

    
    private static class Node<Item> {
    	
        private Item item;
        private Node<Item> next;
        
    }

    
    public Bag() {
    	
        first = null;
        n = 0;
        
    }

    /**
     * Check to see if the bag is empty
     *
     *@return
     *		true if the bag is empty
     */
    public boolean isEmpty() {
    	
        return first == null;
        
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return 
     * 		the number of items in this bag
     */
    public int size() {
    	
        return n;
        
    }

    /**
     * Adds the item to the bag.
     *
     * @param  
     * 		the item to be added to the bag
     */
    public void add(Item item) {
    	
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        
        first.item = item;
        first.next = oldfirst;
        
        n++;
        
    }


    /**
     * Creates an iterator that iterates over the items in the bag
     *
     * @return 
     * 		an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
    	
        return new LinkedIterator(first);
        
    }

    private class LinkedIterator implements Iterator<Item> {
    	
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
        	
            current = first;
            
        }

        public boolean hasNext()  {
        	
            return current != null;
            
        }

        public Item next() {
        	
            if (!hasNext()) throw new NoSuchElementException();
            
            Item item = current.item;
            current = current.next;
            
            return item;
            
        }
        
    }

}
