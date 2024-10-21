/**
 * 
 */
package pq;

/**
 * The following is based on the
 * priority queue data structure
 * with a binary heap implementation
 * 
 * @author Malachai Onwona
 *
 */
public class MaxPQ<T extends Comparable<T>> {
	
	private T[] pq;
	private int N;
	private int capacity = 10;
	
	public MaxPQ() {
		
		pq = (T[]) new Comparable[capacity];
		
	}
	
	
	public boolean less(int a, int b) {
		
		return a - b < 0;
		
	}
	
	public void exchange(int index1, int index2) {
		
		T temp = pq[index2];
		pq[index2] = pq[index1];
		pq[index1] = temp;
		
	}
	
	public void sink(int k) {
		
		while (2*k <= N) {
			
			int j = 2*k;
			
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			
			exchange(k, j);
			k = j;
		}
		
	}
	
	public void swim(int k) {
		
		while (k > 1 && less(k/2,k)) {
			
			exchange(k, k/2);
			k = k/2;
			
		}
		
	}
	
	public void insert(T newNode) {
		
		pq[N++] = newNode;
		swim(N);
		
	}
	
	public T delMax() {
		
		T max = pq[1];
		exchange(1, N--);
		sink(1);
		pq[N+1] = null;
		
		return max;
		
	}
	
	public int size() {
		
		return N;
		
	}
	
	
	public static void main(String[] args) {
		MaxPQ<Integer> maxPQ = new MaxPQ<>();

		// Insert elements
		maxPQ.insert(10);
		maxPQ.insert(20);
		maxPQ.insert(15);

		// Print size of priority queue
		System.out.println("Size of priority queue: " + maxPQ.size());

		// Delete maximum element and print it
		System.out.println("Max element: " + maxPQ.delMax());

		// Print size of priority queue after deletion
		System.out.println("Size of priority queue after deletion: " + maxPQ.size());
		
	}

}
