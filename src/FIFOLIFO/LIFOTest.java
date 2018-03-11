package FIFOLIFO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LIFOTest {

    LIFO<Integer> lifo, lifo2;

    @Before
    public void setUp() throws Exception {
        lifo = new LIFO<>();
        lifo2 = new LIFO<>();

        lifo.add(1);
        lifo.add(2);
        lifo.add(3);
    }

    @Test
    public void contains() {
        assertTrue(lifo.contains(1));
        assertFalse(lifo.contains(10));
    }

    @Test
    public void remove() {
        lifo.remove();
        assertFalse(lifo.contains(3));
    }

    @Test
    public void poll() {
        assertSame(3, lifo.poll());
        assertFalse(lifo.contains(3));
        assertSame(null, lifo2.poll());
    }

    @Test
    public void element() {
        assertSame(3, lifo.element());
        lifo.remove();
        lifo.remove();
        assertSame(1, lifo.element());
        lifo.remove();
        assertTrue(lifo.isEmpty());
    }

    @Test
    public void peek() {
        assertSame(3, lifo.peek());
        assertFalse(lifo.contains(3));
        assertSame(null, lifo2.peek());
    }
}