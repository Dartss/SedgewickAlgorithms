package assignment2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        final int K = Integer.valueOf(args[0]);
        In in = new In(args[1]);
        RandomizedQueue<String> rndQ = new RandomizedQueue<>();
        String n = in.readString();

        while(!in.isEmpty()) {
            rndQ.enqueue(n);
            n = in.readString();
        }

        for (int i = 0, rndQSize = rndQ.size(); i < K && i < rndQSize; i++) {
            StdOut.println(rndQ.dequeue());
        }
    }
}
