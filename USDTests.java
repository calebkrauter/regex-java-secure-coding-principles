/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class USDTests {

    // good input

    @Test
    void testAcceptExample() {
        assertEquals("$123,456,789.23", Regex.usd("$123,456,789.23"));
    }

    @Test
    void testAcceptJustCents() {
        assertEquals("$.23", Regex.usd("$.23"));
    }

    @Test
    void testAccept1Figure() {
        assertEquals("$9.23", Regex.usd("$9.23"));
    }

    @Test
    void testAccept2Figures() {
        assertEquals("$89.23", Regex.usd("$89.23"));
    }

    @Test
    void testAccept3Figures() {
        assertEquals("$789.23", Regex.usd("$789.23"));
    }

    @Test
    void testAccept4Figures() {
        assertEquals("$1,789.23", Regex.usd("$1,789.23"));
    }

    @Test
    void testAccept6Figures() {
        assertEquals("$100,000.00", Regex.usd("$100,000.00"));
    }

    @Test
    void testAccept7Figures() {
        assertEquals("$3,121,789.23", Regex.usd("$3,121,789.23"));
    }

    @Test
    void testAcceptZeros() {
        assertEquals("$0,000,000.00", Regex.usd("$0,000,000.00"));
    }

    // bad input

    @Test
    void testRejectNoCents() {
        assertEquals("", Regex.usd("$100"));
    }

    @Test
    void testRejectAllCommas() {
        assertEquals("", Regex.usd("$100,000,00"));
    }

    @Test
    void testRejectBadCommaInterval() {
        assertEquals("", Regex.usd("$100,00.00"));
    }

    @Test
    void testRejectNoCommas() {
        assertEquals("", Regex.usd("$100000.00"));
    }

    @Test
    void testRejectNoDecimalPoint() {
        assertEquals("", Regex.usd("$100,00000"));
    }

    @Test
    void testRejectNonNumericDollars() {
        assertEquals("", Regex.usd("$c,@$H.00"));
    }

    @Test
    void testRejectNonNumericCents() {
        assertEquals("", Regex.usd("$100.#K"));
    }

    @Test
    void testRejectNoDollarSign() {
        assertEquals("", Regex.usd("100.00"));
    }
}
