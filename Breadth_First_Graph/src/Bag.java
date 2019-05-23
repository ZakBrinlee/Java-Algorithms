import java.util.*;

public class Bag<Item> implements Iterable<Item> {

    private int N; //number of elements in bag
    private Node<Item> root; // beginning of bag, root

    // helper Node class
    private static class Node<Item> {
        private Item element;
        private Node<Item> next;

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(Item element) {
            this.element = element;
            this.next = null;
        }

        public Node(Item element, Node<Item> next) {
            this.element = element;
            this.next = next;
        }
    }//end of Node class


    public Bag(Item e, int s) {
        this.root = new Node<Item>(e);
        this.N = s;
    }

    public Bag(int s) {
        this.N = s;
        root = null;
    }

    public Bag() {
        this.root = null;
        this.N = 0;
    }


    public boolean isEmpty() {
        return N == 0;
    }


    public int size() {
        return N;
    }


    public void add(Item newPort) {
        Node<Item> oldRoot = root;
        root = new Node<Item>();
        root.element = newPort;
        root.next = oldRoot;
        N++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator() {
            this.current = root;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item result = current.element;
            current = current.next;
            return result;
        }
    }


}//end of Bag class
