/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordTests {

    // good input

    @Test
    void testAcceptDefinitelyMyPassword() {
        assertEquals("PasSw.rD1!", Regex.pwd("PasSw.rD1!"));
    }

    @Test
    void testAcceptThreeConsecutiveLowercase() {
        assertEquals("PasSworD1!", Regex.pwd("PasSworD1!"));
    }

    @Test
    void testAcceptNotStartWithUppercase() {
        assertEquals("pasSworD1!", Regex.pwd("pasSworD1!"));
    }

    @Test
    void testAcceptOneUppercase() {
        assertEquals("Pas,wor,1!", Regex.pwd("Pas,wor,1!"));
    }

    @Test
    void testAcceptOneLowercase() {
        assertEquals("PASsWOR,1!", Regex.pwd("PASsWOR,1!"));
    }

    @Test
    void testAcceptFourConsecutiveUppercase() {
        assertEquals("PASS.WoR,1!", Regex.pwd("PASS.WoR,1!"));
    }

    @Test
    void testAcceptConsecutivePunctuation() {
        assertEquals("PAsS..WOR,1!", Regex.pwd("PAsS..WOR,1!"));
    }

    @Test
    void testAcceptMoreThan1Digit() {
        assertEquals("PAsS.WOR,12!", Regex.pwd("PAsS.WOR,12!"));
    }

    // bad input

    @Test
    void testRejectLessThan10Characters() {
        assertEquals("", Regex.pwd("PasSwrD1!"));
    }

    @Test
    void testReject4ConsecutiveLowercase() {
        assertEquals("", Regex.pwd("PASsworD1!"));
    }

    @Test
    void testReject5ConsecutiveLowercase() {
        assertEquals("", Regex.pwd("PASsword1!"));
    }

    @Test
    void testRejectNoUppercase() {
        assertEquals("", Regex.pwd("pa.ss.wor.1!"));
    }

    @Test
    void testRejectNoLowercase() {
        assertEquals("", Regex.pwd("PASSWORD1!"));
    }

    @Test
    void testRejectNoDigit() {
        assertEquals("", Regex.pwd("PASSWORD!!"));
    }

    @Test
    void testRejectNoPunctuation() {
        assertEquals("", Regex.pwd("PASSWORD11"));
    }

    @Test
    void testRejectSpecial() {
        assertEquals("", Regex.pwd("P@$sWORD11"));
    }
}