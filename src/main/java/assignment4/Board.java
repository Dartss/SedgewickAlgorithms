package assignment4;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;


public class Board {
    private MinPQ<Board> pq;
    private int[][] blocks;

    public Board(int[][] blocks) {
        this.blocks = blocks;
        pq = new MinPQ<>();
    }

    public int dimension() {
        return blocks.length;
    }

    private int hamming() {
        return 0;
    }

    private int manhattan() {
        return 0;
    }

    public boolean isGoal() {
        return false;
    }

    public Board twin() {
        return null;
    }

    public Iterable<Board> neigbors() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
