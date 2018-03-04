package PrimeFinder;

import static org.junit.Assert.*;

public class PrimeFinderTest {

    @org.junit.Test
    public void isPrime() {
        assertTrue(PrimeFinder.isPrime(2));
        assertFalse(PrimeFinder.isPrime(4));
        assertFalse(PrimeFinder.isPrime(91));
        assertTrue(PrimeFinder.isPrime(101));
        assertFalse(PrimeFinder.isPrime(1));
        assertFalse(PrimeFinder.isPrime(-1));
        assertFalse(PrimeFinder.isPrime(0));
        assertTrue(PrimeFinder.isPrime(1291234127));
    }
}