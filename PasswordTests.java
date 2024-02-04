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
        assertEquals("PasSw.rD1!", Regex12.password("PasSw.rD1!"));
    }

    @Test
    void testAcceptThreeConsecutiveLowercase() {
        assertEquals("PasSworD1!", Regex12.password("PasSworD1!"));
    }

    @Test
    void testAcceptNotStartWithUppercase() {
        assertEquals("pasSworD1!", Regex12.password("pasSworD1!"));
    }

    @Test
    void testAcceptOneUppercase() {
        assertEquals("Pas,wor,1!", Regex12.password("Pas,wor,1!"));
    }

    @Test
    void testAcceptOneLowercase() {
        assertEquals("PASsWOR,1!", Regex12.password("PASsWOR,1!"));
    }

    @Test
    void testAcceptFourConsecutiveUppercase() {
        assertEquals("PASS.WoR,1!", Regex12.password("PASS.WoR,1!"));
    }

    @Test
    void testAcceptConsecutivePunctuation() {
        assertEquals("PAsS..WOR,1!", Regex12.password("PAsS..WOR,1!"));
    }

    @Test
    void testAcceptMoreThan1Digit() {
        assertEquals("PAsS.WOR,12!", Regex12.password("PAsS.WOR,12!"));
    }

    // bad input

    @Test
    void testRejectLessThan10Characters() {
        assertEquals("", Regex12.password("PasSwrD1!"));
    }

    @Test
    void testReject4ConsecutiveLowercase() {
        assertEquals("", Regex12.password("PASsworD1!"));
    }

    @Test
    void testReject5ConsecutiveLowercase() {
        assertEquals("", Regex12.password("PASsword1!"));
    }

    @Test
    void testRejectNoUppercase() {
        assertEquals("", Regex12.password("pa.ss.wor.1!"));
    }

    @Test
    void testRejectNoLowercase() {
        assertEquals("", Regex12.password("PASSWORD1!"));
    }

    @Test
    void testRejectNoDigit() {
        assertEquals("", Regex12.password("PASSWORD!!"));
    }

    @Test
    void testRejectNoPunctuation() {
        assertEquals("", Regex12.password("PASSWORD11"));
    }

    @Test
    void testRejectSpecial() {
        assertEquals("", Regex12.password("P@$sWORD11"));
    }
}