package FIFOLIFO;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FIFOTest {

    public FIFO<Integer> fifo;
    public FIFO<Integer> fifo2;

    @Before
    public void setUp() throws Exception {
        fifo = new FIFO<>();
        fifo2 = new FIFO<>();
        fifo.add(1);
        fifo.add(3);
        fifo.add(2);
    }

    @Test
    public void contains() {
        assertTrue(fifo.contains(1));
        assertFalse(fifo.contains(10));
    }

    @Test
    public void add() {
        fifo.add(6);
        assertTrue(fifo.contains(6));
    }

    @Test
    public void remove() {
        assertSame(1, fifo.remove());
        assertFalse(fifo.contains(1));
        assertSame(null, fifo2.remove());
    }

    @Test
    public void poll() {
        assertSame(1, fifo.poll());
        assertFalse(fifo.contains(1));
        assertEquals(null, fifo2.poll());
    }

    @Test
    public void element() {
        assertSame(1, fifo.element());
        assertTrue(fifo.contains(1));
        assertSame(null, fifo2.element());
    }

    @Test
    public void peek() {
        assertSame(1, fifo.peek());
        assertTrue(fifo.contains(1));
        assertEquals(null, fifo2.peek());
    }
}