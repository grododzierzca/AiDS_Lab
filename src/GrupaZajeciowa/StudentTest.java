package GrupaZajeciowa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Student a;
    Student b;
    @Before
    public void setUp() throws Exception {
        a = new Student("imie", "nazwisko", 101010, 1, 2, 5, 10);
        a.getZadania().setUzyskaneP(0, 3);
        a.getZadania().setUzyskaneP(1, 5);
        a.getZadania().setUzyskaneP(2, 10);
        a.getZadania().setUzyskaneP(3, 9);
        a.getZadania().setUzyskaneP(4, 10);
        b = new Student("imie", "nazwisko", 101011, 1, 2, 3, 15);
        b.getZadania().setUzyskaneP(0, 12);
        b.getZadania().setUzyskaneP(1, 11);
        b.getZadania().setUzyskaneP(2, 5);
    }

    @Test
    public void update() {
        a.update();
        b.update();
    }

    @After
    public void tearDown() throws Exception {
        assertEquals(4.0, a.getOcena(), 0.001);
        assertEquals(3.5, b.getOcena(), 0.001);
    }
}