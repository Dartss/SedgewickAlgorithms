package assignment3;

import java.util.Arrays;

public class BruteCollinearPoints {
    private Point[] points;

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        this.points = points;
    }

    // the number of line segments
    public int numberOfSegments() {
        return 0;
    }

    // the line segments
    public LineSegment[] segments() {
        int n = points.length;
        LineSegment[] segments = new LineSegment[n * n];
        int segmentsCounter = 0;

        for (int p = 0; p < n; p++) {
            for (int i = p + 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double slpPI = points[p].slopeTo(points[i]);
                    double slpPJ = points[p].slopeTo(points[j]);
                    if (slpPI == slpPJ) {
                        for (int k = j + 1; k < n; k++) {
                            double slpPK = points[p].slopeTo(points[k]);
                            if (slpPK == slpPJ) {
                                Point[] seg = new Point[4];
                                seg[0] = points[p];
                                seg[1] = points[i];
                                seg[2] = points[j];
                                seg[3] = points[k];
                                Arrays.sort(seg);
                                segments[segmentsCounter] = new LineSegment(seg[0], seg[3]);
                                segmentsCounter++;
                            }
                        }
                    }
                }
            }
        }

        return segments;
    }
}