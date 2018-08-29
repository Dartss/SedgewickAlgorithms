package assignment2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;

    private Node first;    // beginning of deque
    private Node last;     // end of deque

    // helper linked list class
    private class Node {
        private final Item item;   // the item in the node
        private Node next;   // reference to next item
        private Node prev;   // reference to previous item

        Node(Item item) {
            this.item = item;
        }
    }

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validateItem(item);

        if (isEmpty()) {
            addVeryFirstItem(item);
        } else {
            Node newFirst = new Node(item);
            newFirst.next = first;
            newFirst.prev = null;

            first.prev = newFirst;

            first = newFirst;
            size++;
        }
    }

    // add the item to the end
    public void addLast(Item item) {
        validateItem(item);

        if (isEmpty()) {
            addVeryFirstItem(item);
        } else {
            Node newLast = new Node(item);
            newLast.prev = last;
            last.next = newLast;

            last = newLast;
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("assignment2.Deque underflow");

        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        size--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("assignment2.Deque underflow");

        Item item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        size--;
        if (isEmpty()) first = null;  // to avoid loitering
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private void validateItem(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    // add very first item to this deque
    private void addVeryFirstItem(Item item) {
        Node veryFirst = new Node(item);
        veryFirst.prev = null;
        veryFirst.next = null;

        first = veryFirst;
        last = veryFirst;

        size++;
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;  // node containing current item

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}