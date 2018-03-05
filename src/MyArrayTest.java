import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class MyArrayTest {

    MyArray<Integer> ar;

    @Before
    public void setUp() throws Exception {
        ar = new MyArray<>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
    }


    @Test
    public void get() {
        assertEquals(2, ar.get(1));
    }

    @Test
    public void set() {
        ar.set(2, 30);
        assertEquals(30, ar.get(2));
    }

    @Test
    public void indexOf() {
        assertEquals(2, ar.indexOf(3));
    }
}