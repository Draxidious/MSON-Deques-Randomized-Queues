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

    private int size;

    public Deque() {
        head = null;
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
        if (head == null) {
            head = new Node(item);
        } else {
            Node newNode = new Node(item);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("tried to addLast with null element");
        if (head == null) {
            head = new Node(item);
        } else {
            Node node = head;
            while (node.hasNext()) {
                node = node.getNext();
            }
            node.setNext(new Node(item));
        }
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeFirst with empty deque");
        size--;
        Node ret = head;
        head = head.getNext();
        return ret.getElement();
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("tried to removeFirst with empty deque");
        size--;
        Node prev = head;
        Node node = head;
        while (node.hasNext()) {
            prev = node;
            node = node.getNext();
        }
        prev.setNext(null);

        return node.getElement();
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
       return null;
    }

    public static void main(String[] args) {
        // unit testing (optional)
    }

    class Node {

        private Item element;
        private Node next;

        Node(Item el) {
            element = el;
            next = null;
        }

        Node() {
            element = null;
            next = null;
        }

        void setNext(Node el) {
            next = el;
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

        boolean hasNext() {
            return next != null;
        }

    }
}

