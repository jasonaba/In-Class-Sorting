import java.util.Arrays;

public class UnderTheSea {

	public static void main(String[] args) {
		// bubble sort
		Node<Integer> head = new Node<Integer>(0);
		Node<Integer> swimmer = head;
		for (int i = 0; i < 10; i++) {
			swimmer.next = new Node<Integer>((int) (Math.random() * 20));
			swimmer = swimmer.next;
		}
		System.out.println(head);
		Sort.sort(head);
		System.out.println(head);

		// merge sort
		int size = 20;
		int[] arrayToSort = new int[size];

		for (int i = 0; i < size; i++) {
			arrayToSort[i] = (int) (Math.random() * 20);
		}
		System.out.println(Arrays.toString(arrayToSort));
		Sort.quickSort(arrayToSort);
		System.out.println(Arrays.toString(arrayToSort));

	}
}
