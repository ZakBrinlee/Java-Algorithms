import java.util.Arrays;
import java.lang.Object;

public class HashIntSet {
    private static final int EMPTY = 0;
    private static final int REMOVED = -9999999;   // special value used on removal
    private static final double MAX_LOAD = 0.75;   // load factor on which to rehash

    private int[] elements;
    private int size;

    // Constructs a new empty set of integers.
    public HashIntSet() {
        elements = new int[10];
        size = 0;
    }

    // Adds the given value to this set,
    // if it was not already contained in the set.
    public int add(int value) {
        // resize if necessary
        if (loadFactor() > MAX_LOAD) {
            rehash();
        }

        // linear probing to find proper index
        int h = hash(value);
        while (elements[h] != EMPTY && elements[h] != value && elements[h] != REMOVED) {
            h = (h + 1) % elements.length;
        }

        // add the element
        if (elements[h] != value) {
            elements[h] = value;
            size++;
        }

        return h;
    }

    // Returns whether the given value is found in this set.
    public boolean contains(int value) {
        // linear probing to find proper index
        int h = hash(value);
        while (elements[h] != 0) {
            if (elements[h] == value) {
                return true;
            }
            h = (h + 1) % elements.length;
        }
        return false;
    }

    // Returns true if there are no elements in this set.
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the hash table's "load factor", its ratio of size to capacity.
    public double loadFactor() {
        return (double) size / elements.length;
    }

    // Removes the given element value from this set,
    // if it was found in the set.
    public void remove(int value) {
        // linear probing to find proper index
        int h = hash(value);
        while (elements[h] != EMPTY && elements[h] != value) {
            h = (h + 1) % elements.length;
        }

        // remove the element
        if (elements[h] == value) {
            elements[h] = REMOVED;
            size--;
        }
    }


    // Returns a text representation of this set.
    // TODO: finish (this is not a proper toString; it shows the internal array)
    public void printSet() {

        for (int i = 0; i < elements.length; i++) {
            System.out.println(i + ": " + elements[i] + " ");
        }
    }


    // hash function for mapping values to indexes
    private int hash(int value) {
        return Math.abs(value) % elements.length;
    }

    // Resizes the hash table to twice its original capacity.
    private void rehash() {
        int[] old = elements;
        elements = new int[(int)(1.5 * old.length)];
        size = 0;
        for (int value : old) {
            if (value != 0) {
                add(value);
            }
        }
    }

}//end of HashIntSet