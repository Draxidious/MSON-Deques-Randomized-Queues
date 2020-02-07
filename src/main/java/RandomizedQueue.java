/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 *
 *  Compilation:  javac-algs4 RandomizedQueue.java
 *  Execution:    java-algs4 RandomizedQueue
 *  Dependencies: Item.java Iterator.java
 *
 *  Description:  Implementing a Queue that chooses elements at random using an array
 ******************************************************************************/

import java.util.Arrays;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size = 0;
    private Item[] queue;
    private int rear;

    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        rear = queue.length;
        // construct an empty randomized queue
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {

        return size;
    }

    public void enqueue(Item item) {
        // double size if array is full
        if (size == queue.length) {
            queue = (Item[]) new Object[queue.length * 2];
            queue[size] = item;
            size++;
        } else {
            queue[size] = item;
            size++;
        }
    }

    public Item dequeue() {
        if (size == queue.length / 4) {
            queue = (Item[]) new Object[queue.length / 2];

            size--;
        } else {
           size--;
        }
        // half is array is quarter filled
        // remove and return a random item
        // keep track of rear with number(points to last el)
        // dequeue random, then replace it with rear
        // update rear to next last element

        return null;
    }

    public Item sample() {
        // return a random item (but do not remove it)
        return null;
    }

    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private Item[] iterArray = (Item[]) new Object[queue.length];

        public RandomIterator() {
            for (int i = 0; i < iterArray.length; i++) {
                iterArray[i] = queue[i];
            }
        }

        @Override
        public boolean hasNext() {

            return false;
        }

        @Override
        public Item next() {


            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }
}