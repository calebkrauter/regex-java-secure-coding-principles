/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameTests {

    // good input

    @Test
    void testAcceptMyName() {
        assertEquals("Claar, Trae, W", Regex.name("Claar, Trae, W"));
    }

    @Test
    void testAcceptTom() {
        assertEquals("Capaul, Tom, B", Regex.name("Capaul, Tom, B"));
    }

    @Test
    void testAcceptGeorgeWashington() {
        assertEquals("Washington, George, IDK", Regex.name("Washington, George, IDK"));
    }

    @Test
    void testAcceptTwoMiddleInitials() {
        assertEquals("Claar, Trae, WO", Regex.name("Claar, Trae, WO"));
    }

    @Test
    void testAcceptThreeMiddleInitials() {
        assertEquals("Claar, Trae, WOO", Regex.name("Claar, Trae, WOO"));
    }

    @Test
    void testAcceptOneDigitLastName() {
        assertEquals("C, Trae, W", Regex.name("C, Trae, W"));
    }

    @Test
    void testAcceptOneDigitFirstName() {
        assertEquals("Claar, T, W", Regex.name("Claar, T, W"));
    }

    @Test
    void testAcceptNoMiddleInitial() {
        assertEquals("Claar, Trae", Regex.name("Claar, Trae"));
    }

    // bad input

    @Test
    void testRejectMissingFirstName() {
        assertEquals("", Regex.name("Claar, , W"));
    }

    @Test
    void testRejectMissingLastName() {
        assertEquals("", Regex.name(", Trae, W"));
    }

    @Test
    void testRejectMissingCommas() {
        assertEquals("", Regex.name("Claar Trae W"));
    }

    @Test
    void testRejectFullMiddleName() {
        assertEquals("", Regex.name("Claar, Trae, Weston"));
    }

    @Test
    void testRejectUncapitalizedLastName() {
        assertEquals("", Regex.name("claar, Trae, W"));
    }

    @Test
    void testRejectUncapitalizedFirstName() {
        assertEquals("", Regex.name("Claar, trae, W"));
    }

    @Test
    void testRejectUncapitalizedMiddleInitial() {
        assertEquals("", Regex.name("Claar, Trae, w"));
    }

    @Test
    void testRejectDigits() {
        assertEquals("", Regex.name("Claar1, Tr4ae, W"));
    }

    @Test
    void testRejectSpecialCharacters() {
        assertEquals("", Regex.name("Cl@ar, Tra!e, W"));
    }
}