import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.Scanner;

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
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue q = new RandomizedQueue();
        String str = StdIn.readString();
        String add = "";
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                q.enqueue(add);
                add = "";
            } else {
                add += str.charAt(i);
            }
        }
        Iterator<String> iter = q.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
