import assignment2.Deque;
import org.junit.Test;
import static org.junit.Assert.*;

public class DequeTest {

    @Test
    public void emptyTest() {
        Deque<String> deque = new Deque<>();
        assertTrue(deque.isEmpty());
        deque.addFirst("a");
        assertFalse(deque.isEmpty());
    }

    @Test
    public void addFirstTest() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("one");
        deque.addFirst("two");
        deque.addFirst("three");
        deque.addFirst("four");

        assertSame(deque.removeFirst(), "four");
        assertSame(deque.removeFirst(), "three");
        assertSame(deque.removeFirst(), "two");
        assertSame(deque.removeFirst(), "one");
    }

    @Test
    public void addLastTest(){
        Deque<String> deque = new Deque<>();
        deque.addLast("one");
        deque.addLast("two");
        deque.addLast("three");
        deque.addLast("four");

        assertSame(deque.removeLast(), "four");
        assertSame(deque.removeLast(), "three");
        assertSame(deque.removeLast(), "two");
        assertSame(deque.removeLast(), "one");
    }

    @Test
    public void emptyNonEmptyStateRepeatTest() {
        Deque<String> deque = new Deque<>();
        deque.addFirst("one");
        deque.addFirst("two");

        assertSame(deque.removeFirst(), "two");
        assertSame(deque.removeFirst(), "one");

        deque.addLast("last");

        assertSame(deque.removeFirst(), "last");

        deque.addFirst("first");

        assertSame(deque.removeLast(), "first");
    }
}
