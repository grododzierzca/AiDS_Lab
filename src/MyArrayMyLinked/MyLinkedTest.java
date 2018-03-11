package MyArrayMyLinked;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedTest {

    MyLinked<Integer> lk;

    @Before
    public void setUp() throws Exception {
        lk = new MyLinked<>();
        lk.add(1);
        lk.add(2);
        lk.add(3);
    }

    @Test
    public void indexOf() {
        assertEquals(0, lk.indexOf(1));
    }

    @Test
    public void set() {
        lk.set(2, 30);
        assertEquals((Integer) 30, lk.get(2));
    }

    @Test
    public void get() {
        assertEquals((Integer) 1, lk.get(0));
    }
}