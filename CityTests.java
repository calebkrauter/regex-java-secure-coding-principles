import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CityTests {

    // good input

    @Test
    void testAcceptTacoma() {
        assertEquals("Tacoma, WA 98402", Regex.city("Tacoma, WA 98402"));
    }

    @Test
    void testAcceptSeattle() {
        assertEquals("Seattle, WA 98101", Regex.city("Seattle, WA 98101"));
    }

    @Test
    void testAcceptZipPlus4() {
        assertEquals("Olympia, WA 98501-1234", Regex.city("Olympia, WA 98501-1234"));
    }

    @Test
    void testAcceptNonWAState() {
        assertEquals("Rancho Cucamonga, CA 91701", Regex.city("Rancho Cucamonga, CA 91701"));
    }

    @Test
    void testAcceptLongCityName() {
        assertEquals("Kleinfeltersville, PA 17039", Regex.city("Kleinfeltersville, PA 17039"));
    }

    @Test
    void testAcceptOneLetterCity() {
        assertEquals("Y, AK 99688", Regex.city("Y, AK 99688"));
    }

    @Test
    void testAcceptTwoLetterCity() {
        assertEquals("Ai, OH 43558", Regex.city("Ai, OH 43558"));
    }

    @Test
    void testAcceptCityWithSpace() {
        assertEquals("New York, NY 11004", Regex.city("New York, NY 11004"));
    }

    // bad input

    @Test
    void testRejectCityWithDash() {
        assertEquals("", Regex.city("Wilkes-Barre, PA 18769"));
    }

    @Test
    void testRejectCityWithApostrophe() {
        assertEquals("", Regex.city("Cour d'Alene, ID 83814"));
    }

    @Test
    void testRejectNoComma() {
        assertEquals("", Regex.city("Tacoma WA 98401"));
    }

    @Test
    void testRejectNoCity() {
        assertEquals("", Regex.city(", WA 98401"));
    }

    @Test
    void testRejectLowercaseCity() {
        assertEquals("", Regex.city("tacoma, WA 98401"));
    }

    @Test
    void testRejectNoState() {
        assertEquals("", Regex.city("Tacoma, 98401"));
    }

    @Test
    void testRejectNoZipCode() {
        assertEquals("", Regex.city("Tacoma, WA"));
    }

    @Test
    void testRejectNoSpaces() {
        assertEquals("", Regex.city("Tacoma,WA98501"));
    }

    @Test
    void testRejectLowercaseState() {
        assertEquals("", Regex.city("Tacoma, wa 98501"));
    }

    @Test
    void testRejectShortZipCode() {
        assertEquals("", Regex.city("Tacoma, WA 9850"));
    }

    @Test
    void testRejectLongZipCode() {
        assertEquals("", Regex.city("Tacoma, WA 985011"));
    }

    @Test
    void testRejectNonNumericZipCode() {
        assertEquals("", Regex.city("Tacoma, WA ABCDE"));
    }
}
