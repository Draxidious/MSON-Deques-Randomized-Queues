/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 *
 *  Compilation:  javac-algs4 Deque.java
 *  Execution:    java-algs4 Deque
 *  Dependencies: Item.java Iterator.java
 *
 *  Description:  Implementing a Deque using linked structures
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque class for princeton project.
 *
 * @param <Item> object of type random
 */
public class Deque<Item> implements Iterable<Item> {
    /**
     * The head node of the queue.
     */
    private Node head;
    /**
     * The tail end of queue.
     */
    private Node tail;
    /**
     * The size of the queue.
     */
    private int size;

    public Deque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("tried to addFirst with null element");

        if (isEmpty()) {
            head = new Node(item);
        } else {
            Node newNode = new Node(item);
            newNode.setNext(head);
            head.setBefore(newNode);
            head = newNode;
        }
        size++;
        if (size == 2) {
            tail = head.getNext();
        }
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("tried to addLast with null element");
        if (isEmpty()) {
            head = new Node(item);
        } else if (size == 1) {
            Node newNode = new Node(item);
            head.setNext(newNode);
            newNode.setBefore(head);
            tail = newNode;
        } else {
            Node newNode = new Node(item);
            tail.setNext(newNode);
            newNode.setBefore(tail);
            tail = newNode;
        }
        size++;
        if (size == 2) {
            head = tail.getBefore();
        }
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeFirst with empty deque");
        Node ret;
        if (size == 1) {
            ret = head;
            head = null;
        } else {
            ret = head;
            head = head.getNext();
            head.setBefore(null);
        }
        size--;
        if (size == 1) {
            tail = null;
        }
        return ret.getElement();
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeLast with empty deque");
        Node ret;
        if (size == 1) {
            ret = head;
            head = null;
        } else {
            ret = tail;
            tail = tail.getBefore();
            tail.setNext(null);
        }
        size--;
        if (size == 1) {
            head = tail;
            tail = null;
        }


        return ret.getElement();
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    /**
     * Iterator class to Iterate over deque.
     */
    private class DequeIterator implements Iterator<Item> {
        /**
         * Current node to iterate over queue.
         */
        private Node cur = head;

        @Override
        public boolean hasNext() {

            return cur != null;
        }

        @Override
        public Item next() {
            if (cur == null) throw new NoSuchElementException("There are no more items for iterator to return");
            Item it = cur.getElement();
            cur = cur.getNext();

            return it;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() Operation not supported");
        }
    }

    public static void main(String[] args) {

    }

    /**
     * Node class for handling deque.
     */
    private class Node {
        /**
         * Element in node.
         */
        private Item element;
        /**
         * Next node linked by current node.
         */
        private Node next;
        /**
         * Node linked to current node.
         */
        private Node before;

        Node(Item el) {
            element = el;
            next = null;
            before = null;
        }

        Node() {
            element = null;
            next = null;
            before = null;
        }

        void setNext(Node el) {
            next = el;
        }

        void setBefore(Node el) {
            before = el;
        }

        public void setElement(Item el) {
            element = el;
        }

        Item getElement() {
            return element;
        }

        Node getNext() {
            return next;
        }

        Node getBefore() {
            return before;
        }

        boolean hasNext() {
            return next != null;
        }

        boolean hasBefore() {
            return before != null;
        }

    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node cur = head;
        if (isEmpty()) return ".\n";
        if (head == null && tail != null) return tail.getElement() + "\n";
        while (cur != null) {
            ret.append(cur.getElement()).append("\n");
            cur = cur.getNext();
        }
        return ret.toString() + "\n-----";
    }
}

