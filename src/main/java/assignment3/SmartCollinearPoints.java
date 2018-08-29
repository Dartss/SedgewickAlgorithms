package assignment3;

import java.util.Arrays;
import java.util.Comparator;

public class SmartCollinearPoints {
    private Point[] points;

    public SmartCollinearPoints(Point[] points) {
        this.points = points;
    }

    public LineSegment[] segments() {
        System.out.println("Input");
        printArr(points);

        Arrays.sort(points);
        System.out.println("First sort");
        printArr(points);

        final int N = points.length;

        LineSegment[] segments = new LineSegment[N];

        Point startPoint = points[0];
        Comparator<Point> comparator = startPoint.slopeOrder();

        Arrays.sort(points, comparator);
        System.out.println("Second sort");
        printArr(points);

        return segments;
    }

    private void printArr(Point[] arr) {
        for (Point p : arr) {
            System.out.print(p + " ");
        }
        System.out.println();
    }
}
