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

public class Deque<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;

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
        size++;
        if (head == null) {
            head = new Node(item);
        } else {
            Node newNode = new Node(item);
            newNode.setNext(head);
            head.setBefore(newNode);
            head = newNode;

        }

    } 

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("tried to addLast with null element");
        size++;
        if (head == null) {
            head = new Node(item);
        } else if (tail == null) {
            tail = new Node(item);
        } else {
            Node newNode = new Node(item);
            tail.setNext(newNode);
            newNode.setBefore(tail);
            tail = newNode;

        }

    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeFirst with empty deque");
        size--;
        if (head == null) {
            Node ret = tail;
            return ret.getElement();
        }
        Node ret = head;
        head = head.getNext();
        return ret.getElement();
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeLast with empty deque");
        size--;
        if (tail == null) {
            Node ret = head;
            return ret.getElement();
        }

        Node ret = tail;
        System.out.println(ret.getElement());
        tail = tail.getBefore();
        return ret.getElement();
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return null;
    }

    private class DequeIterator implements Iterator<Item> {

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

    private class Node {

        private Item element;
        private Node next;
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
            return next != null;
        }

    }
}

