package assignment2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Deque<Item> items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = new Deque<>();
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // return the number of items on the randomized queue
    public int size() {
        return items.size();
    }

    // add the item
    public void enqueue(Item item) {
        if (StdRandom.uniform(2) % 2 == 0) {
            items.addFirst(item);
        } else {
            items.addLast(item);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        return items.removeFirst();
    }

    // return a random item (but do not remove it)
    public Item sample() {
        Item item = dequeue();
        items.addFirst(item);
        return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return items.iterator();
    }
}
