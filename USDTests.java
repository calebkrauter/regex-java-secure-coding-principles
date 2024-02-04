/**
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * @author Trae Claar and (modified) by Caleb Krauter
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class USDTests {

    // good input

    @Test
    void testAcceptExample() {
        assertEquals("$123,456,789.23", Regex12.usCurrency("$123,456,789.23"));
    }

    @Test
    void testAcceptJustCents() {
        assertEquals("$.23", Regex12.usCurrency("$.23"));
    }

    @Test
    void testAccept1Figure() {
        assertEquals("$9.23", Regex12.usCurrency("$9.23"));
    }

    @Test
    void testAccept2Figures() {
        assertEquals("$89.23", Regex12.usCurrency("$89.23"));
    }

    @Test
    void testAccept3Figures() {
        assertEquals("$789.23", Regex12.usCurrency("$789.23"));
    }

    @Test
    void testAccept4Figures() {
        assertEquals("$1,789.23", Regex12.usCurrency("$1,789.23"));
    }

    @Test
    void testAccept6Figures() {
        assertEquals("$100,000.00", Regex12.usCurrency("$100,000.00"));
    }

    @Test
    void testAccept7Figures() {
        assertEquals("$3,121,789.23", Regex12.usCurrency("$3,121,789.23"));
    }

    @Test
    void testAcceptZeros() {
        assertEquals("$0,000,000.00", Regex12.usCurrency("$0,000,000.00"));
    }

    // bad input

    @Test
    void testRejectNoCents() {
        assertEquals("", Regex12.usCurrency("$100"));
    }

    @Test
    void testRejectAllCommas() {
        assertEquals("", Regex12.usCurrency("$100,000,00"));
    }

    @Test
    void testRejectBadCommaInterval() {
        assertEquals("", Regex12.usCurrency("$100,00.00"));
    }

    @Test
    void testRejectNoCommas() {
        assertEquals("", Regex12.usCurrency("$100000.00"));
    }

    @Test
    void testRejectNoDecimalPoint() {
        assertEquals("", Regex12.usCurrency("$100,00000"));
    }

    @Test
    void testRejectNonNumericDollars() {
        assertEquals("", Regex12.usCurrency("$c,@$H.00"));
    }

    @Test
    void testRejectNonNumericCents() {
        assertEquals("", Regex12.usCurrency("$100.#K"));
    }

    @Test
    void testRejectNoDollarSign() {
        assertEquals("", Regex12.usCurrency("100.00"));
    }
}
