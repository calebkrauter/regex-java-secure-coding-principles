import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Trae C (modified) by Caleb Krauter
 */

public class AddressTests {

    // good input

    @Test
    void testAcceptUWTacoma() {
        assertEquals("1900 Commerce Street", Regex12.houseAddress("1900 Commerce Street"));
    }

    @Test
    void testAcceptUWTacomaAbbrev() {
        assertEquals("1900 Commerce ST", Regex12.houseAddress("1900 Commerce ST"));
    }

    @Test
    void testAcceptSingleDigitNumber() {
        assertEquals("1 Main Street", Regex12.houseAddress("1 Main Street"));
    }

    @Test
    void testAcceptBoulevard() {
        assertEquals("10 Some Boulevard", Regex12.houseAddress("10 Some Boulevard"));
    }

    @Test
    void testAcceptBLVD() {
        assertEquals("10 Some BLVD", Regex12.houseAddress("10 Some BLVD"));
    }

    @Test
    void testAcceptAvenue() {
        assertEquals("10 Some Avenue", Regex12.houseAddress("10 Some Avenue"));
    }

    @Test
    void testAcceptAVE() {
        assertEquals("10 Some AVE", Regex12.houseAddress("10 Some AVE"));
    }

    @Test
    void testAcceptRoad() {
        assertEquals("10 Some Road", Regex12.houseAddress("10 Some Road"));
    }

    @Test
    void testAcceptRD() {
        assertEquals("10 Some RD", Regex12.houseAddress("10 Some RD"));
    }

    @Test
    void testAcceptTwoWordName() {
        assertEquals("2 One Two AVE", Regex12.houseAddress("2 One Two AVE"));
    }

    @Test
    void testAcceptNumbersInName() {
        assertEquals("140 21st AVE", Regex12.houseAddress("140 21st AVE"));
    }

    // bad input

    @Test
    void testRejectNoNumber() {
        assertEquals("", Regex12.houseAddress("Main Street"));
    }

    @Test
    void testRejectNoName() {
        assertEquals("", Regex12.houseAddress("12 Street"));
    }

    @Test
    void testRejectNoStreetType() {
        assertEquals("", Regex12.houseAddress("12 Main"));
    }

    @Test
    void testRejectNonNumericNumber() {
        assertEquals("", Regex12.houseAddress("A Main Street"));
    }

    @Test
    void testRejectNoSpaces() {
        assertEquals("", Regex12.houseAddress("12MainStreet"));
    }

    @Test
    void testRejectDashesAsSeparators() {
        assertEquals("", Regex12.houseAddress("12-Main-Street"));
    }   
    
    @Test
    void testRejectNoSpaceBetweenNameAndStreet() {
        assertEquals("", Regex12.houseAddress("12 MainStreet"));
    }

    @Test
    void testRejectNegativeNumber() {
        assertEquals("", Regex12.houseAddress("-12 Main ST"));
    }
}
