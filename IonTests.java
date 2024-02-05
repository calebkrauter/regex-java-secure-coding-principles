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
        assertEquals("ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion"));
    }

    @Test
    void testAcceptOnion() {
        assertEquals("onion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("onion"));
    }

    @Test
    void testAcceptOnionCapitalized() {
        assertEquals("Onion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("Onion"));
    }

    @Test
    void testAcceptAnimation() {
        assertEquals("animation", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("animation"));
    }

    @Test
    void testAcceptDoubleIon() {
        assertEquals("ion ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion ion"));
    }

    @Test
    void testAcceptTripleIon() {
        assertEquals("ion ion ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion ion ion"));
    }

    @Test
    void testAcceptTripleIonNonWhitespaceSeparators() {
        assertEquals("ion ion ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion$ion-ion"));
    }

    @Test
    void testAcceptDoubleIonLongerSeparator() {
        assertEquals("ion ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion    ansjk$dbasj&      ion"));
    }

    // bad input

    @Test
    void testRejectLion() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("lion"));
    }

    @Test
    void testRejectDoubleIonNoSeperator() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ionion"));
    }

    @Test
    void testRejectIonCapitalized() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("Ion"));
    }

    @Test
    void testRejectDigits() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("123ion"));
    }

    @Test
    void testRejectNonWordCharacters() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("@.#a!nion"));
    }

    @Test
    void testRejectIncludesButDoesNotEndWithIon() {
        assertEquals("", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ionized"));
    }

    @Test
    void testRejectInvalidThenValid() {
        assertEquals("ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("lion ion"));
    }

    @Test
    void testRejectValidThenInvalid() {
        assertEquals("ion", Regex12.wordsContainingOddNumOfAlphabeticalCharactersEndingInIon("ion lion"));
    }
}
