package merge;

/**
 * This class is an implementation of 
 * Bottom-Up merge sort
 * 
 * @author Malachai Onwona
 *
 */

public class MergeSortBU<T extends Comparable<T>> {
	
	private T[] original;
	private T[] temp;
	
	public MergeSortBU(T[] a) {
		
		this.original = a;
		this.temp = (T[]) new Comparable[a.length];
		sort(a);
		
	}
	
	
	/**
	 * Uses the compareTo() method from Comparable
	 * to check if the value of the object in the first 
	 * parameter is less than the value of the object 
	 * in the second parameter
	 * 
	 * @param <T>
	 * @param a
	 * 		The first object which is being
	 * 		compared to the second object
	 * @param b
	 * 		The second object which is being
	 * 		used for comparison
	 * @return
	 * 		True if the first object is less
	 * 		than the second
	 */
	
	public static<T extends Comparable<T>> boolean less(T a, T b) {
		
		return a.compareTo(b) < 0;
		
	}
	
	public void sort(T[] a) {
		
		int n = a.length;
		temp = (T[]) new Comparable[n];
		for (int i = 1; i < n; i=i+i) {
			for (int lo = 0; lo < n - i; lo+=i+i) {
				mergesort(lo,lo+i-1,Math.min(lo+i+i-1, i-1));
			}
		}
		
	}
	
	/**
	 * The merge sort algorithm. Sorts two subarrays
	 * of the original array and merges them 
	 * into a single sorted array at the end.
	 * 
	 * @param lo
	 * 		The first index in the array
	 * @param mid
	 * 		The middle index in the array
	 * @param hi
	 * 		The last index in the array
	 */
	
	public void mergesort(int lo, int mid, int hi) {
		
		for (int i = lo; i <= hi; i++) {
			temp[i] = original[i];
		}
		
		int a = lo;
		int b = mid+1;
		
		for (int x = lo; x <= hi; x++) {
			
			if (a > mid) {
				original[x] = temp[b++];
			}
			else if (b > hi) {
				original[x] = temp[a++];
			}
			else if (less(temp[a],temp[b])) {
				original[x] = temp[a++];
			}
			else {
				original[x] = temp[b++];
			}
		}
		
	}
	
	
	/**
	 * Client code to test the correctness of
	 * my merge sort implementation. Used an array
	 * of strings for testing but any data type that
	 * can be compared, can be used.
	 * 
	 * @param args
	 * 		The arguments
	 */
	
	public static void main(String[] args) {
        String[] arr = {"appli", "dlkd", "dldka","nnvld", "oin", "qlken"};
        MergeSortBU<String> sorter = new MergeSortBU<>(arr);
        sorter.mergesort(0, arr.length/2, arr.length-1);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
