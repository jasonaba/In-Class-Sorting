import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>, Iterable<T> {
    T data;
    Node<T> next;

    Node(T data) { this.data = data; }

    /** Nodes are ordered by their data. */
    @Override
    public int compareTo(Node<T> other) {
        return this.data.compareTo(other.data);
    }

    /** Iterates over the data from this node to the end of the list. */
    @Override
    public Iterator<T> iterator() {
        final Node<T> start = this;
        return new Iterator<T>() {
            private Node<T> current = start;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) throw new NoSuchElementException();
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }

	@Override
	public String toString() {
		return data + "->" + next;
	}
    
    
    
}