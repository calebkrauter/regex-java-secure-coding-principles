import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TimeTests {

    // good input

    @Test
    void testAcceptTimeOfWriting() {
        assertEquals("1408", Regex.time("1408"));
    }

    @Test
    void testAcceptMidnight() {
        assertEquals("0000", Regex.time("0000"));
    }

    @Test
    void testAccept2359() {
        assertEquals("2359", Regex.time("2359"));
    }

    @Test
    void testAccept1930() {
        assertEquals("1930", Regex.time("1930"));
    }

    @Test
    void testAccept2045() {
        assertEquals("2045", Regex.time("2045"));
    }

    @Test
    void testAccept1100() {
        assertEquals("1100", Regex.time("1100"));
    }

    @Test
    void testAccept1327() {
        assertEquals("1327", Regex.time("1327"));
    }

    @Test
    void testAccept1610() {
        assertEquals("1610", Regex.time("1610"));
    }

    // bad input

    @Test
    void testRejectWithColon() {
        assertEquals("", Regex.time("14:32"));
    }

    @Test
    void testRejectWithSeconds() {
        assertEquals("", Regex.time("143224"));
    }

    @Test
    void testRejectHour24() {
        assertEquals("", Regex.time("2400"));
    }

    @Test
    void testRejectMinute60() {
        assertEquals("", Regex.time("0060"));
    }

    @Test
    void testRejectNegative() {
        assertEquals("", Regex.time("-0547"));
    }

    @Test
    void testRejectDouble() {
        assertEquals("", Regex.time("1712 1712"));
    }

    @Test
    void testRejectMissingDigit() {
        assertEquals("", Regex.time("094"));
    }

    @Test
    void testRejectMissingSection() {
        assertEquals("", Regex.time("11"));
    }

    @Test
    void testRejectNonNumeric() {
        assertEquals("", Regex.time("FIVE"));
    }

    @Test
    void testRejectPrepend() {
        assertEquals("", Regex.time("time1234"));
    }

    @Test
    void testRejectAppend() {
        assertEquals("", Regex.time("1234hrs"));
    }
}
