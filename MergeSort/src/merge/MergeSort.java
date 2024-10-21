/**
 * 
 */
package merge;

/**
 * This class is an implementation
 * of the merge sort algorithm
 * 
 * @author Malachai Onwona
 *
 */
public class MergeSort<T extends Comparable<T>>{
	
	private T[] original;
	private T[] temp;
	private static final int CUTOFF = 7;  //The cutoff number for use of insertion sort
	
	public MergeSort(T[] a) {
		
		this.original = a;
		this.temp = (T[]) new Comparable[a.length];
		sort(0, a.length - 1);
		
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
	
	/**
	 * This method exchanges two elements of an array
	 * 
	 * @param a
	 * 		The generic type array in which two of its
	 * 		elements will be swapped/exchanged
	 * @param index1
	 * 		The first index used in the exchange
	 * @param index2
	 * 		The second index used in the exchange
	 */
	public void exchange(T[]a, int index1, int index2) {
		
		T temp = a[index2];
		a[index2] = a[index1];
		a[index1] = temp;
		
	}
	
	/**
	 * This method deals with the sorting in 
	 * this class. When the number of elements
	 * in the array is below a certain cutoff, 
	 * insertion sort is used for small subarrays 
	 * instead of merge sort because it has less 
	 * overhead for these cases. Otherwise,
	 * merge sort is used by recursively making 
	 * calls to sort() and then finally a call to
	 * mergesort().
	 * 
	 * @param lo
	 * 		The first index of the array
	 * @param hi
	 * 		The last index of the array
	 */
	
	public void sort(int lo, int hi) {
		if (hi <= lo + CUTOFF -1) {
			insertionsort(original, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(lo, mid);
		sort(mid + 1, hi);
		if (!less(original[mid+1],original[mid]))return; //Check to stop if the array is already sorted
		mergesort(lo, mid, hi);
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
	 * Practical Improvement: Utilize insertion Sort for 
	 * small subarrays because merge sort has too much overhead 
	 * for tiny subarrays
	 * 
	 * @param a
	 * 		The generic type array to be sorted
	 */
	
	public void insertionsort(T[] a, int lo, int hi) {
		
		for (int i = lo; i <= hi; i++) {
	        for (int x = i; x > lo && less(a[x], a[x-1]); x--) {
	            exchange(a, x, x-1);
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
        MergeSort<String> sorter = new MergeSort<>(arr);
        sorter.mergesort(0, arr.length/2, arr.length-1);

        // Print the sorted array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
