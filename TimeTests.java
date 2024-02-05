import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * @author Trae Claar and (modified) by Caleb Krauter
 */


public class TimeTests {

    // good input

    @Test
    void testAcceptTimeOfWriting() {
        assertEquals("1408", Regex12.militaryTime("1408"));
    }

    @Test
    void testAcceptMidnight() {
        assertEquals("0000", Regex12.militaryTime("0000"));
    }

    @Test
    void testAccept2359() {
        assertEquals("2359", Regex12.militaryTime("2359"));
    }

    @Test
    void testAccept1930() {
        assertEquals("1930", Regex12.militaryTime("1930"));
    }

    @Test
    void testAccept2045() {
        assertEquals("2045", Regex12.militaryTime("2045"));
    }

    @Test
    void testAccept1100() {
        assertEquals("1100", Regex12.militaryTime("1100"));
    }

    @Test
    void testAccept1327() {
        assertEquals("1327", Regex12.militaryTime("1327"));
    }

    @Test
    void testAccept1610() {
        assertEquals("1610", Regex12.militaryTime("1610"));
    }

    // bad input

    @Test
    void testRejectWithColon() {
        assertEquals("", Regex12.militaryTime("14:32"));
    }

    @Test
    void testRejectWithSeconds() {
        assertEquals("", Regex12.militaryTime("143224"));
    }

    @Test
    void testRejectHour24() {
        assertEquals("", Regex12.militaryTime("2400"));
    }

    @Test
    void testRejectMinute60() {
        assertEquals("", Regex12.militaryTime("0060"));
    }

    @Test
    void testRejectNegative() {
        assertEquals("", Regex12.militaryTime("-0547"));
    }

    @Test
    void testRejectDouble() {
        assertEquals("", Regex12.militaryTime("1712 1712"));
    }

    @Test
    void testRejectMissingDigit() {
        assertEquals("", Regex12.militaryTime("094"));
    }

    @Test
    void testRejectMissingSection() {
        assertEquals("", Regex12.militaryTime("11"));
    }

    @Test
    void testRejectNonNumeric() {
        assertEquals("", Regex12.militaryTime("FIVE"));
    }

    @Test
    void testRejectPrepend() {
        assertEquals("", Regex12.militaryTime("time1234"));
    }

    @Test
    void testRejectAppend() {
        assertEquals("", Regex12.militaryTime("1234hrs"));
    }
}
