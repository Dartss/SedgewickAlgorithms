package assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int N; // dimension of the matrix
    private final int VIRTUAL_TOP_SITE_ID = 0;
    private final int VIRTUAL_BOT_SITE_ID;

    private boolean[][] matrix; // representation of opened/blocked sites

    private final WeightedQuickUnionUF UF;

    private int opened; // counter of opened sites

    public Percolation(int n) throws IllegalArgumentException {
        if (n <= 0) throw new IllegalArgumentException("Matrix dimension should be > 0");

        N = n;
        VIRTUAL_BOT_SITE_ID = N * N + 1;

        UF = new WeightedQuickUnionUF(VIRTUAL_BOT_SITE_ID + 1);
        matrix = new boolean[N][N];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);

        matrix[row - 1][col - 1] = Boolean.TRUE; // opening given site
        opened++;

        int openedSiteId = getId(row, col);

        int upSiteId = getUpSiteId(row, col);
        int downSiteId = getDownSiteId(row, col);
        int leftSiteId = getLeftSiteId(row, col);
        int rightSiteId = getRightSiteId(row, col);

        if (upSiteId > 0) {
            if (isOpen(row - 1, col)) UF.union(openedSiteId, upSiteId);
        } else {
            // all sites in first row, should be connected with virtual top site
            UF.union(openedSiteId, VIRTUAL_TOP_SITE_ID);
        }

        if (downSiteId > 0) {
            if (isOpen(row + 1, col)) UF.union(openedSiteId, downSiteId);
        } else {
            // all sites in last row, should be connected with virtual bottom site
            UF.union(openedSiteId, VIRTUAL_BOT_SITE_ID);
        }

        if (leftSiteId > 0) {
            if (isOpen(row, col - 1)) UF.union(openedSiteId, leftSiteId);
        }
        if (rightSiteId > 0) {
            if (isOpen(row, col + 1)) UF.union(openedSiteId, rightSiteId);
        }
    }

    private int getUpSiteId(int row, int col) {
        if (row > 1) return getId(row - 1, col);
        return -1;
    }

    private int getDownSiteId(int row, int col) {
        if (row < N) return getId(row + 1, col);
        return -1;
    }

    private int getLeftSiteId(int row, int col) {
        if (col > 1) return getId(row, col - 1);
        return -1;
    }

    private int getRightSiteId(int row, int col) {
        if (col < N) return getId(row, col + 1);
        return -1;
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return matrix[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        return isOpen(row, col) && UF.connected(getId(row, col), VIRTUAL_TOP_SITE_ID);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return opened;
    }

    // does the system percolate?
    public boolean percolates() {
        return UF.connected(VIRTUAL_TOP_SITE_ID, VIRTUAL_BOT_SITE_ID);
    }

    /**
     * Checks whether given column and row indices are valid.
     *
     * @param row row index
     * @param col column index
     * @throws IllegalArgumentException exception will be thrown if row or column index (or both)
     *                                  will be out of matrix grid.
     */
    private void validate(int row, int col) throws IllegalArgumentException {
        if ((row <= 0 && row > N) || (col <= 0 && col > N)) throw new IllegalArgumentException("");
    }

    /**
     * Converts given column and row indices into a naming number.
     *
     * @param row row index
     * @param col column index
     * @return unique integer name of each site in the matrix grid.
     */
    private int getId(int row, int col) {
        return row * N - (N - col);
    }

}
