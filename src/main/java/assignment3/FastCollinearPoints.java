package assignment3;

import java.util.Arrays;
import java.util.Comparator;

public class FastCollinearPoints {
    private Point[] points;
    private Point[] sorted;
    private Comparator<Point> comparator;
    private final int N;

    public FastCollinearPoints(Point[] points) {
        N = points.length;
        this.points = points;
        this.sorted = new Point[N];
        System.arraycopy(points, 0, sorted, 0, N);
    }

    public LineSegment[] segments() {
        LineSegment[] rawSegments = new LineSegment[N * N];
        int segmentsCounter = 0;

        Arrays.sort(points);
        for (int sp = 0; sp < N; sp++) {
            Point startPoint = points[sp];
            comparator = startPoint.slopeOrder();

            Arrays.sort(sorted);
            sort(sorted, new Point[N], 0, N);

            Point prevPoint;
            Point currentPoint;
            Point biggest;
            double prevSlop;
            double currentSlop;

            for (int i = 1; i < N; i++) {
                int collinearsCount = 2;
                biggest = startPoint;
                prevPoint = sorted[i - 1];
                currentPoint = sorted[i];
                prevSlop = startPoint.slopeTo(prevPoint);
                currentSlop = startPoint.slopeTo(currentPoint);

                // to define points as collinear they should have same slope to start point
                // and also, both previous and current points, should be bigger or less then start point.
                // In other words start point should be on start or on the end of the line.
                while (prevSlop == currentSlop &&
                        ((prevPoint.compareTo(startPoint) > 0 && currentPoint.compareTo(startPoint) > 0) ||
                                (prevPoint.compareTo(startPoint) < 0 && currentPoint.compareTo(startPoint) < 0))) {

                    if (currentPoint.compareTo(biggest) > 0) biggest = currentPoint;

                    collinearsCount++;

                    i++;
                    if (i < N) {
                        prevPoint = sorted[i - 1];
                        currentPoint = sorted[i];
                        prevSlop = startPoint.slopeTo(prevPoint);
                        currentSlop = startPoint.slopeTo(currentPoint);
                    } else {
                        break;
                    }
                }

                if (collinearsCount >= 4 && biggest.compareTo(startPoint) != 0) {
                    LineSegment segment = new LineSegment(startPoint, biggest);
                    rawSegments[segmentsCounter] = segment;
                    segmentsCounter++;
                }
            }
        }

        LineSegment[] segments = new LineSegment[segmentsCounter];
        System.arraycopy(rawSegments, 0, segments, 0, segmentsCounter);

        return segments;
    }

    private void merge(Point[] a, Point[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (comparator.compare(a[j], a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }

        // copy back
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }

    private void sort(Point[] a, Point[] aux, int lo, int hi) {

        // base case
        if (hi - lo <= 1) return;

        // sort each half, recursively
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid, hi);

        // merge back together
        merge(a, aux, lo, mid, hi);
    }
}
