/**
 * 
 */
package bst;

import java.util.NoSuchElementException;

/**
 * @author Malachai Onwona
 *
 */
public class BST<Key extends Comparable<Key>, Value> extends Queue<Key> {
	
	private Node root;
	
	public BST() {
		
	}
	
	private class Node {
		
		private Key key;
		private Value value;
		private Node left, right;
		private int size;
		
		public Node(Key key, Value value, int size) {
			
			this.key = key;
			this.value = value;
			this.size = size;

		}
		
	}
	
	
	public int size() {
		
		return size(root);
		
	}
	
	private int size(Node node) {
		
		if (node == null) return 0;
		
		else return node.size;
		
	}
	
	public boolean isEmpty() {
		
		return size() == 0;
		
	}
	
	
	public void put(Key key, Value value) {
		
		root = put(root, key, value);
		
	}
	
	private Node put(Node node, Key key, Value value) {
		
		if (node == null) return new Node(key, value, 1);
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		}
		if (cmp > 0) {
			node.right = put(node.right, key, value);
		}
		
		else node.value = value;
		
		return node;
		
	}
	
	public Value get(Key key) {
		
		Node r = root;
		
		while (r != null) {
			
			int cmp = key.compareTo(r.key);
			
			if (cmp < 0) r = r.left;
			if (cmp > 0) r = r.right;
			
			else return r.value;
		}
		
		return null;
		
	}
	
	public boolean contains(Key key) {
		
		return get(key) != null;
		
	}
	
	public Key min() {
		
		if (isEmpty()) throw new NoSuchElementException();
		
		Node node = min(root);
		
		return node.key;
		
	}
	
	private Node min(Node node) {
		
		if (node.left == null) return node;
		
		return min(node.left);
		
	}
	
	public Key max() {
		
		if (isEmpty()) throw new NoSuchElementException();
		
		Node node = max(root);
		
		return node.key;
		
	}
	
	private Node max(Node node) {
		
		if (node.right == null) return node;
		
		return max(node.right);
		
	}
	
	public Key floor(Key key) {
		
		Node node = floor(root, key);
		
		if (node == null) throw new NoSuchElementException();
		
		return node.key;
		
	}
	
	private Node floor(Node node, Key key) {
		
		if (node == null) return null;
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) return node;
		if(cmp < 0) return floor(node.left, key);
		
		Node rNode = floor(node.right, key);
		
		if (rNode != null) return rNode;
		else return node;
		
	}
	
	public Key ceiling(Key key) {
		
		Node node = ceiling(root, key);
		
		if (node == null) throw new NoSuchElementException();
		
		return node.key;
		
	}
	
	private Node ceiling(Node node, Key key) {
		
		if (node == null) return null;
		
		int cmp = key.compareTo(node.key);
		
		if (cmp == 0) return node;
		if(cmp > 0) return floor(node.right, key);
		
		Node lNode = ceiling(node.left, key);
		
		if (lNode != null) return lNode;
		else return node;
		
	}
	
	public Key select(int k) {
		
		if (k < 0 || k >= size()) throw new IllegalArgumentException();
		
		Node node = select(root, k);
		
		return node.key;
		
	}
	
	private Node select(Node node, int k) {
		
		if (node == null) return null;
		
		int x = size(node.left);
		
		if (x > k) return select(node.left, k);
		else if (x < k) return select(node.right, k-x-1);
		else return node;
		
	}
	
	public int rank(Key key) {
		
		return rank(key, root);
		
	}
	
	private int rank(Key key, Node node) {
		
		if (node == null) return 0;
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) return rank(key, node.left);
		else if (cmp > 0) return 1 + size(node.left) + rank(key, node.right);
		else return size(node.left);
		
	}
	
	public void deleteMin() {
		
		if (isEmpty())throw new NoSuchElementException();
		
		root = deleteMin(root);
		
	}
	
	private Node deleteMin(Node node) {
		
		if (node.left == null) return node.right;
		
		node.left = deleteMin(node.left);
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
		
	}
	
	public void delete(Key key) {
		
		root = delete(root, key);
		
	}
	
	private Node delete(Node node, Key key) {
		
		if (node == null) return null;
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) node.left = delete(node.left, key);
		if (cmp > 0) node.right = delete(node.right, key);
		
		else {
			
			if (node.right == null) return node.left;
			if (node.left == null) return node.right;
			
			Node del = node;
			
			node = min(del.right);
			node.right = deleteMin(del.right);
			node.left = del.left;
			
		}
		
		node.size = size(node.left) + size(node.right) + 1;
		
		return node;
		
	}
	
	public Iterable<Key> keys(){
		
		return keys(min(), max());
		
	}
	
	public Iterable<Key> keys(Key lo, Key hi){
		
		Queue<Key> queue = new Queue<Key>();
		
		keys(root, queue, lo, hi);
		
		return queue;
	
	}
	
	private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
		
		if (node == null) return;
		
		int cmplo = lo.compareTo(node.key);
		int cmphi = hi.compareTo(node.key);
		
		if (cmplo < 0) keys(node.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
		if (cmphi > 0) keys(node.right, queue, lo, hi);
		
	}
	
	
	public static void main(String[] args) {
	    
	}

}
