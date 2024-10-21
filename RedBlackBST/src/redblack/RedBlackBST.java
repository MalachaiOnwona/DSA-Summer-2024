/**
 * 
 */
package redblack;

/**
 * @author Malachai Onwona
 *
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public RedBlackBST() {
		
	}
	
	private class Node {
		
		Key key;
		Value value;
		Node left, right;
		int size;
		boolean color;
		
		public Node(Key key, Value value, int size, boolean color) {
			
			this.key = key;
			this.value = value;
			this.size = size;
			this.color = color;

		}
		
	}
	
	
	public int size() {
		
		return size(root);
		
	}
	
	private int size(Node node) {
		
		if (node == null) return 0;
		
		else return node.size;
		
	}
	
	private boolean isRed(Node node) {
		
		if (node == null) return false;
		
		return node.color == RED;
		
	}
	
	public Node rotateLeft(Node node) {
		
		Node replace = node.right;
		node.right = replace.left;
		replace.left = node;
		
		replace.color = node.color;
		node.color = RED;  //this node is red because the link between it and its parent is red
		replace.size = node.size;
		node.size = 1 + size(node.left) + size(node.right);
		
		return replace;
		
	}
	
	public Node rotateRight(Node node) {
		
		Node replace = node.left;
		node.left = replace.right;
		replace.right = node;
		
		replace.color = node.color;
		node.color = RED;  //this node is red because the link between it and its parent is red
		replace.size = node.size;
		node.size = 1 + size(node.left) + size(node.right);
		
		return replace;
		
	}
	
	private void flipColors(Node node) {
		
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
		
	}
	
	public void put(Key key, Value value) {
		
		root = put(root, key, value);
		root.color = BLACK;
		
	}
	
	private Node put(Node node, Key key, Value value) {
		
		if (node == null) return new Node(key, value, 1, RED);
		
		int cmp = key.compareTo(node.key);
		
		if (cmp < 0) {
			node.left = put(node.left, key, value);
		}
		if (cmp > 0) {
			node.right = put(node.right, key, value);
		}
		
		else node.value = value;
		
		if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
		if (isRed(node.left) && !isRed(node.left.left)) node = rotateRight(node);
		if (isRed(node.right) && isRed(node.left)) flipColors(node);
		
		node.size = 1 + size(node.left) + size(node.right);
		
		return node;
		
	}
	
	//delete(), deleteMin(), and deleteMax() methods are implemented in exercises

}
