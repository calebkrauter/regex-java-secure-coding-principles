/**
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * @author Trae Claar (modified) by Caleb Krauter
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NameTests {

    // good input

    @Test
    void testAcceptMyName() {
        assertEquals("Clear, Trail, W", Regex12.nameOnRoster("Clear, Trail, W"));
    }

    @Test
    void testAcceptTom() {
        assertEquals("Capaul, Tom, B", Regex12.nameOnRoster("Capaul, Tom, B"));
    }

    @Test
    void testAcceptGeorgeWashington() {
        assertEquals("Washington, George, IDK", Regex12.nameOnRoster("Washington, George, IDK"));
    }

    @Test
    void testAcceptTwoMiddleInitials() {
        assertEquals("Clear, Trail, WO", Regex12.nameOnRoster("Clear, Trail, WO"));
    }

    @Test
    void testAcceptThreeMiddleInitials() {
        assertEquals("Clear, Trail, WOO", Regex12.nameOnRoster("Clear, Trail, WOO"));
    }

    @Test
    void testAcceptOneDigitLastName() {
        assertEquals("C, Trae, W", Regex12.nameOnRoster("C, Trae, W"));
    }

    @Test
    void testAcceptOneDigitFirstName() {
        assertEquals("Claar, T, W", Regex12.nameOnRoster("Claar, T, W"));
    }

    @Test
    void testAcceptNoMiddleInitial() {
        assertEquals("Clear, Trail", Regex12.nameOnRoster("Clear, Trail"));
    }

    // bad input

    @Test
    void testRejectMissingFirstName() {
        assertEquals("", Regex12.nameOnRoster("Claar, , W"));
    }

    @Test
    void testRejectMissingLastName() {
        assertEquals("", Regex12.nameOnRoster(", Trae, W"));
    }

    @Test
    void testRejectMissingCommas() {
        assertEquals("", Regex12.nameOnRoster("Claar Trae W"));
    }

    @Test
    void testRejectFullMiddleName() {
        assertEquals("", Regex12.nameOnRoster("Clear, Trail, Weston"));
    }

    @Test
    void testRejectUncapitalizedLastName() {
        assertEquals("", Regex12.nameOnRoster("Clear, Trail, W"));
    }

    @Test
    void testRejectUncapitalizedFirstName() {
        assertEquals("", Regex12.nameOnRoster("Clear, Trail, W"));
    }

    @Test
    void testRejectUncapitalizedMiddleInitial() {
        assertEquals("", Regex12.nameOnRoster("Clear, Trail, w"));
    }

    @Test
    void testRejectDigits() {
        assertEquals("", Regex12.nameOnRoster("Claar1, Tr4ae, W"));
    }

    @Test
    void testRejectSpecialCharacters() {
        assertEquals("", Regex12.nameOnRoster("Cl@ar, Tra!e, W"));
    }
}