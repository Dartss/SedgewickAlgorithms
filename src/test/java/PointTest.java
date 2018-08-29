import assignment3.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void compareTest() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(3, 2);
        Point p4 = new Point(2, 2);
        Point p5 = new Point(1, 2);

        assertSame(0, p1.compareTo(p4)); // should be equal
        assertSame(-1, p1.compareTo(p2));
        assertSame(-1, p1.compareTo(p3));
        assertSame(1, p1.compareTo(p5));
    }
}
