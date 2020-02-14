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
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Randomized Queue class.
 *
 * @param <Item> object of type item.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    /**
     * Size of usable array, rest of array is empty.
     */
    private int size = 0;
    /**
     * Array used to utilize constant-time retrieval.
     */
    private Item[] queue;
    /**
     * Rear element index number.
     */
    private int rearel;

    /**
     * RandomizedQueue constructor.
     */
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        rearel = queue.length - 1;
        // construct an empty randomized queue
    }

    /**
     * Checks if queue is empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * Returns the size of the queue.
     *
     * @return size
     */
    public int size() {

        return size;
    }

    /**
     * Enqueus element.
     *
     * @param item element
     */
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Tried to enqueue null element");
        if (size == queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 2);
        }
        queue[size] = item;
        rearel = size;
        size++;
    }
    /**
     * Dequeues elemtn at random.
     *
     * @return item dequeued
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Tried to dequeue empty queue");
        if (size == queue.length / 4) {
            queue = Arrays.copyOf(queue, queue.length / 2);
        }
        int ran = StdRandom.uniform(0, size);
        Item ret = queue[ran];
        queue[ran] = queue[rearel];
        queue[rearel] = null;
        size--;
        rearel = size - 1;
        return ret;
    }

    /**
     * Samples the queues.
     *
     * @return random item
     */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Tried to sample an empty queue");
        int num = StdRandom.uniform(0, size);

        return queue[num];
    }
    /**
     * Returns iterator.
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RandomIterator();
    }

    /**
     * Random Iterator that retrieves items in random order.
     */
    private class RandomIterator implements Iterator<Item> {
        /**
         * An array to traverse for iterator.
         * Used as copy of usable array portion of random queue
         */
        private Item[] iterArray = (Item[]) new Object[size];
        /**
         * Index number to traverse array.
         */
        private int num = 0;

        /**
         * RandomIterator Constructor.
         */
        public RandomIterator() {
            for (int i = 0; i < size; i++) {
                iterArray[i] = queue[i];
            }
            StdRandom.shuffle(iterArray);
        }

        /**
         * Checks if there is another element in deque.
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {

            return num != size;
        }

        /**
         * Gets next element.
         *
         * @return next element
         */
        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException("There are no more items for iterator to return");

            Item el = iterArray[num];
            num++;
            return el;
        }

        /**
         * Unsupported.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() Operation not supported");
        }
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }
}