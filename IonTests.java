/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class IonTests {

    // good input

    @Test
    void testAcceptIon() {
        assertEquals("ion", Regex.ion("ion"));
    }

    @Test
    void testAcceptOnion() {
        assertEquals("onion", Regex.ion("onion"));
    }

    @Test
    void testAcceptOnionCapitalized() {
        assertEquals("Onion", Regex.ion("Onion"));
    }

    @Test
    void testAcceptAnimation() {
        assertEquals("animation", Regex.ion("animation"));
    }

    @Test
    void testAcceptDoubleIon() {
        assertEquals("ion ion", Regex.ion("ion ion"));
    }

    @Test
    void testAcceptTripleIon() {
        assertEquals("ion ion ion", Regex.ion("ion ion ion"));
    }

    @Test
    void testAcceptTripleIonNonWhitespaceSeparators() {
        assertEquals("ion ion ion", Regex.ion("ion$ion-ion"));
    }

    @Test
    void testAcceptDoubleIonLongerSeparator() {
        assertEquals("ion ion", Regex.ion("ion    ansjk$dbasj&      ion"));
    }

    // bad input

    @Test
    void testRejectLion() {
        assertEquals("", Regex.ion("lion"));
    }

    @Test
    void testRejectDoubleIonNoSeperator() {
        assertEquals("", Regex.ion("ionion"));
    }

    @Test
    void testRejectIonCapitalized() {
        assertEquals("", Regex.ion("Ion"));
    }

    @Test
    void testRejectDigits() {
        assertEquals("", Regex.ion("123ion"));
    }

    @Test
    void testRejectNonWordCharacters() {
        assertEquals("", Regex.ion("@.#a!nion"));
    }

    @Test
    void testRejectIncludesButDoesNotEndWithIon() {
        assertEquals("", Regex.ion("ionized"));
    }

    @Test
    void testRejectInvalidThenValid() {
        assertEquals("ion", Regex.ion("lion ion"));
    }

    @Test
    void testRejectValidThenInvalid() {
        assertEquals("ion", Regex.ion("ion lion"));
    }
}
