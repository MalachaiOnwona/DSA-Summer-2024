/**
 * 
 */
package quick;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author Malachai Onwona
 *
 */
public class QuickSort<T extends Comparable<T>> {
	
	public static final int CUTOFF = 10;
	
	
	public QuickSort(){
		
	}
	
	
	public boolean less(T a, T b) {
		
		return a.compareTo(b) < 0;
		
	}
	
	public void exchange(T[]a, int index1, int index2) {
		
		T temp = a[index2];
		a[index2] = a[index1];
		a[index1] = temp;
		
	}
	
	public int partition(T[]a, int lo, int hi) {
		
		int i = lo;
		int j = hi;
		
		while(true) {
			
			while(less(a[i++], a[lo])) {
				if (i == hi) break;
			}
			while (less(a[lo], a[j--])) {
				if (j == lo) break;
			}
			if (i >= j) break;
			
			exchange(a, i, j);
		}
		
		exchange(a, lo, j);
		
		return j;
		
	}
	
	public void sort(T[] a) {
		
		StdRandom.shuffle(a);
		quicksort(a, 0, a.length-1);
	}
	
	public void quicksort(T[] a, int lo, int hi) {
		
		if (hi <= lo + CUTOFF - 1) {
			
			insertionsort(a, lo, hi);
			return;
			
		}
		
		int key = partition(a, lo, hi);
		
		quicksort(a, lo, key-1);
		quicksort(a, key+1, hi);
	}
	
	public void insertionsort(T[] a, int lo, int hi) {
		
		for (int i = lo; i <= hi; i++) {
	        for (int x = i; x > lo && less(a[x], a[x-1]); x--) {
	            exchange(a, x, x-1);
	        }
	    }
		
	}
	
	
	public static void main(String[] args) {
        char[] arr = {'a','k','l','x','q','o','g','r','g','w','e','c','z','u','i'};
        
        QuickSort<Character> sorter = new QuickSort<>();
        
        sorter.sort(arr);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
