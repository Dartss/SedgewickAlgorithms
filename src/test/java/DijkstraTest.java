import org.junit.Test;
import static org.junit.Assert.*;
public class DijkstraTest {
    @Test
    public void sumTest(){
        String expression = "(2 + 2)";
        assertSame(4, Dijkstra.calculate(expression));
    }

    @Test
    public void minusTest(){
        String expression = "(5 - 3)";
        assertSame(2, Dijkstra.calculate(expression));
    }

    @Test
    public void multiplyTest(){
        String expression = "(2 * 3)";
        assertSame(6, Dijkstra.calculate(expression));
    }

    @Test
    public void divideTest(){
        String expression = "(9 / 3)";
        assertSame(3, Dijkstra.calculate(expression));
    }

    @Test
    public void complexExpressionTest1() {
        String expression = "(8 * 2) + ((4 - 9) - (1 - 7))";
        assertSame(17, Dijkstra.calculate(expression));
    }

    @Test
    public void complexExpressionBigDigits() {
        String expression = "((11 * 2) - 2) + (30 / 3)";
        assertSame(30, Dijkstra.calculate(expression));
    }
}
