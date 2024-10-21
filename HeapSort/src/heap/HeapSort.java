package heap;

public class HeapSort<T extends Comparable<T>> {
	
	private T[] heap;
	private int capacity = 10;
	
	public HeapSort() {
		
		heap = (T[]) new Comparable[capacity];
		
	}
	
	
	public boolean less(int a, int b) {
		
		return a - b < 0;
		
	}
	
	public void exchange(int index1, int index2) {
		
		T temp = heap[index2];
		heap[index2] = heap[index1];
		heap[index1] = temp;
		
	}
	
	public void sink() {
		
	}
	
	public void swim(int k) {
		
		while(k > 1 && less(k/2, k)) {
			
			exchange(k, k/2);
			k = k/2;
		}
	}

}
