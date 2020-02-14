import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

/******************************************************************************
 *  Name:    Kevin Wayne
 *  Login:   wayne
 *  Precept: P02
 *
 *  Partner Name:    N/A
 *  Partner Login:   N/A
 *  Partner Precept: N/A
 *
 *  Compilation:  javac-algs4 Permutation.java
 *  Execution:    java-algs4 Permutation k < <filename>
 *  Dependencies: RandomizedQueue.java StdIn.java StdOut.java
 *
 *  Description:  Takes an integer k as a command-line argument; reads in a sequence of strings from standard input using StdIn.readString(); and prints exactly k of them, uniformly at random. 
 *  Prints each item from the sequence at most once. 
 ******************************************************************************/

/**
 * Permutation class.
 */
public class Permutation {
    /**
     * Main method.
     * @param args k
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> q = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
            if (q.size() > k) {
                q.dequeue();
            }
        }


        Iterator iter = q.iterator();
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            if (iter.hasNext()) {
                System.out.println(iter.next());
            } else {
                break;
            }

        }

    }

}
