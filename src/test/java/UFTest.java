import assignment1.QuickUnionUF;
import assignment1.UF;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UFTest {
    UF uf;

    @Before
    public void prepareUnion() {
        uf = new QuickUnionUF(10);
        uf.union(1,2);
        uf.union(3,4);
        uf.union(5,6);
        uf.union(7,8);
        uf.union(5, 0);
        uf.union(7,9);
        uf.union(8,2);
    }

    @Test
    public void test1() {
        assertTrue(uf.connected(1, 2));
    }

    @Test
    public void test2() {
        assertTrue(uf.connected(3,4));
    }

    @Test
    public void test3() {
        assertFalse(uf.connected(1,3));
    }

    @Test
    public void test4() {
        assertTrue(uf.connected(1,9));
    }
}
