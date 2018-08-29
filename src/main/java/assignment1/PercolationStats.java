package assignment1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.DoubleStream;

public class PercolationStats {
    private final int N; // dimension of the grid
    private final int T; // number of trials to perform

    private double[] openSitesFractions;

    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) throws IllegalArgumentException {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        N = n;
        T = trials;

        openSitesFractions = new double[T];
        performTests();
    }

    private void performTests() {
        int nsqr = N * N;
        for (int i = 0; i < T; i++) {
            Percolation p = new Percolation(N);
            while (!p.percolates()) {
                int rndRow = StdRandom.uniform(1, N + 1);
                int rndCol = StdRandom.uniform(1, N + 1);
                if (!p.isOpen(rndRow, rndCol)) p.open(rndRow, rndCol);
            }
            openSitesFractions[i] = (double) p.numberOfOpenSites() / nsqr;
        }
        mean = DoubleStream.of(openSitesFractions).sum() / T;
        stddev = Math.sqrt(DoubleStream.of(openSitesFractions).map(d -> Math.pow(d - mean, 2)).sum() / (T - 1));
        confidenceHi = mean + (1.96 * stddev) / Math.sqrt(T);
        confidenceLo = mean - (1.96 * stddev) / Math.sqrt(T);
    }

    // sample mean of percolation threshold
    public double mean() {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return stddev;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return confidenceLo;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return confidenceHi;
    }

    // test client (described below)
    public static void main(String[] args) {
        if (args.length != 2) throw new IllegalArgumentException("Expecting 2 arguments: dimension and trials!");
        int dimension = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats s = new PercolationStats(dimension, trials);

        System.out.println("mean                    = " + s.mean());
        System.out.println("stddev                  = " + s.stddev());
        System.out.println("95% confidence interval = [" + s.confidenceLo + ", " + s.confidenceHi + ']');
    }
}