
import java.util.Arrays;

public class Sort {
	static boolean bubbleSort, insertionSort, mergeSort;

	private static <T> void swap(Comparable<T>[] arr, int i, int j) {
		if(i<0 || j<0 || i>=arr.length || j>=arr.length) {
			return;
		}
		Comparable<T> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void swap(int[] arr, int i, int j) {
		if(i<0 || j<0 || i>=arr.length || j>=arr.length) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static <T extends Comparable<T>> void sort(Node<T> head) {
		bubbleSort = true;
		insertionSort = false;
		if (head == null)
			return;
		if (bubbleSort) {

			Node<T> diver = head;
			Node<T> anchor = null;
			boolean swapped;
			do {
				swapped = false;
				while (diver.next != anchor) {
					if (diver.data.compareTo(diver.next.data) > 0) {// swap
						T temp = diver.data;
						diver.data = diver.next.data;
						diver.next.data = temp;
						swapped = true;
					}
					diver = diver.next;
				}
				anchor = diver;
				diver = head;
			} while (swapped);
		} else if (insertionSort) {
			Node<T> aux = head;
			Node<T> temp = head;
			while (head.next != null) {
				if(aux.data.compareTo(head.data)>0) {
					aux.next = temp;
					
				}
			}
		}
	}

	// Merge Sort
	
	public static void bottomUpMergeSort(int[] arr) {
		int[] aux = new int[arr.length];
		int n = arr.length;
		for(int section = 1; section<arr.length; section*=2) {
			for(int start = 0; start<arr.length; start +=section*2) {
				int mid = Math.min(n-1, start + section-1);
				int end = Math.min(start+2*section-1, n-1);
				recombine(arr,aux,start,mid,end);
			}
		}
	}
	
	public static void mergeSort(int[] arr) {
		int[] tempArray = new int[arr.length];
		partition(arr, tempArray, 0, arr.length - 1);

	}

	public static void partition(int[] arr, int[] tempArray, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			partition(arr, tempArray, start, middle);
			partition(arr, tempArray, middle + 1, end);
			recombine(arr, tempArray, start, middle, end);
		}

	}

	public static void recombine(int[] arr, int[] tempArray, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		for (int k = start; k <= end; k++) {
			if (i > middle)
				tempArray[k] = arr[j++];
			else if (j > end)
				tempArray[k] = arr[i++];
			else if (arr[i] <= arr[j])
				tempArray[k] = arr[i++];
			else
				tempArray[k] = arr[j++];
		}

		for (int k = start; k <= end; k++)
			arr[k] = tempArray[k];

	}
	
	// Quick Sort
	public static void quickSort(int[] arr) {
		
		helper(arr, 0, arr.length-1);
		
	}

	/**
	 * Helper to quickSort: Splits array into sections and pivots it
	 * @param arr
	 * @param start
	 * @param end
	 */
	private static void helper(int[] arr, int start, int end) {
		if(start<end) {
			int wait = pivot(arr, start, end);
			helper(arr, start, wait-1);//sort the left side of the list
			helper(arr, wait+1, end);
		}
	}
	
	public static int pivot(int[] arr, int start, int end) {
		int randomSpot = (int)(Math.random()*(end-start+1))+start;//gets a random pivot in the split list
		swap(arr, randomSpot, end);//makes the end the pivot
		int wait = start;
		for(int runner = start; runner<end; runner++) {
			if(arr[runner]<arr[end]) {//compares dory against the pivot
				swap(arr, runner, wait);
				wait++;
			}
		}
		
		swap(arr, end, wait);//swaps the pivot with the one we are on
		return wait;
	}
}