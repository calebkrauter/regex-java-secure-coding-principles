import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * @author Trae Claar and (modified) by Caleb Krauter
 */
public class CityTests {

    // good input

    @Test
    void testAcceptTacoma() {
        assertEquals("Tacoma, WA 98402", Regex12.extendedAddress("Tacoma, WA 98402"));
    }

    @Test
    void testAcceptSeattle() {
        assertEquals("Seattle, WA 98101", Regex12.extendedAddress("Seattle, WA 98101"));
    }

    @Test
    void testAcceptZipPlus4() {
        assertEquals("Olympia, WA 98501-1234", Regex12.extendedAddress("Olympia, WA 98501-1234"));
    }

    @Test
    void testAcceptNonWAState() {
        assertEquals("Rancho Cucamonga, CA 91701", Regex12.extendedAddress("Rancho Cucamonga, CA 91701"));
    }

    @Test
    void testAcceptLongCityName() {
        assertEquals("Kleinfeltersville, PA 17039", Regex12.extendedAddress("Kleinfeltersville, PA 17039"));
    }

    @Test
    void testAcceptOneLetterCity() {
        assertEquals("Y, AK 99688", Regex12.extendedAddress("Y, AK 99688"));
    }

    @Test
    void testAcceptTwoLetterCity() {
        assertEquals("Ai, OH 43558", Regex12.extendedAddress("Ai, OH 43558"));
    }

    @Test
    void testAcceptCityWithSpace() {
        assertEquals("New York, NY 11004", Regex12.extendedAddress("New York, NY 11004"));
    }

    // bad input

    @Test
    void testRejectCityWithDash() {
        assertEquals("", Regex12.extendedAddress("Wilkes-Barre, PA 18769"));
    }

    @Test
    void testRejectCityWithApostrophe() {
        assertEquals("", Regex12.extendedAddress("Cour d'Alene, ID 83814"));
    }

    @Test
    void testRejectNoComma() {
        assertEquals("", Regex12.extendedAddress("Tacoma WA 98401"));
    }

    @Test
    void testRejectNoCity() {
        assertEquals("", Regex12.extendedAddress(", WA 98401"));
    }

    @Test
    void testRejectNoState() {
        assertEquals("", Regex12.extendedAddress("Tacoma, 98401"));
    }

    @Test
    void testRejectNoZipCode() {
        assertEquals("", Regex12.extendedAddress("Tacoma, WA"));
    }

    @Test
    void testRejectNoSpaces() {
        assertEquals("", Regex12.extendedAddress("Tacoma,WA98501"));
    }

    @Test
    void testRejectLowercaseState() {
        assertEquals("", Regex12.extendedAddress("Tacoma, wa 98501"));
    }

    @Test
    void testRejectShortZipCode() {
        assertEquals("", Regex12.extendedAddress("Tacoma, WA 9850"));
    }

    @Test
    void testRejectLongZipCode() {
        assertEquals("", Regex12.extendedAddress("Tacoma, WA 985011"));
    }

    @Test
    void testRejectNonNumericZipCode() {
        assertEquals("", Regex12.extendedAddress("Tacoma, WA ABCDE"));
    }
}
