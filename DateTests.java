import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * @author Trae Claar (modified) by Caleb Krauter
 */

public class DateTests {
    // good input
    @Test
    void testAcceptDateTodaySlashes() {
        assertEquals("01/31/2024", Regex12.date("01/31/2024"));
    }

    @Test
    void testAcceptDateTodayDashes() {
        assertEquals("01-31-2024", Regex12.date("01-31-2024"));
    }

    @Test
    void testAcceptDateFeb29LeapYear() {
        assertEquals("02-29-2024", Regex12.date("02-29-2024"));
    }

    @Test
    void testAcceptDate01010000() {
        assertEquals("01-01-0000", Regex12.date("01-01-0000"));
    }

    @Test
    void testAcceptDate12319999() {
        assertEquals("12/31/9999", Regex12.date("12/31/9999"));
    }

    @Test
    void testAcceptDateOct30() {
        assertEquals("10/30/2002", Regex12.date("10/30/2002"));
    }

    @Test
    void testAcceptDateSep20() {
        assertEquals("09-20-1984", Regex12.date("09-20-1984"));
    }

    @Test
    void testAcceptDateDay19() {
        assertEquals("05/19/1812", Regex12.date("05/19/1812"));
    }

    @Test
    void testAcceptDateDay10() {
        assertEquals("07-10-1491", Regex12.date("07-10-1491"));
    }

    @Test
    void testAcceptDateDay9() {
        assertEquals("03-09-1212", Regex12.date("03-09-1212"));
    }

    //bad input
    @Test
    void testRejectDateAll0() {
        assertEquals("", Regex12.date("00/00/0000"));
    }

    @Test
    void testRejectDateNoSeparators() {
        assertEquals("", Regex12.date("07041776"));
    }

    @Test
    void testRejectDateIncorrectSeparators() {
        assertEquals("", Regex12.date("03 15 2020"));
    }

    @Test
    void testRejectDateNonNumericMonth() {
        assertEquals("", Regex12.date("MM-21-0768"));
    }

    @Test
    void testRejectDateNonNumericDay() {
        assertEquals("", Regex12.date("08-DD-2452"));
    }

    @Test
    void testRejectDateNonNumericYear() {
        assertEquals("", Regex12.date("04-18-YYYY"));
    }

    @Test
    void testRejectDateTooLongMonth() {
        assertEquals("", Regex12.date("043-12-2018"));
    }

    @Test
    void testRejectDateTooLongDay() {
        assertEquals("", Regex12.date("11-123-1618"));
    }

    @Test
    void testRejectDateTooLongYear() {
        assertEquals("", Regex12.date("07-09-11328"));
    }

    @Test
    void testRejectDateDoubled() {
        assertEquals("", Regex12.date("08/20/197208/20/1972"));
    }

    @Test
    void testRejectDateFeb29NonLeapYear() {
        assertEquals("", Regex12.date("02/29/2022"));
    }

    @Test
    void testRejectDateFeb29NonLeapYear2() {
        assertEquals("", Regex12.date("02/29/1900"));
    }

    @Test
    void testRejectDateFeb30LeapYear() {
        assertEquals("", Regex12.date("02/30/2024"));
    }

    @Test
    void testRejectDateDec32() {
        assertEquals("", Regex12.date("12/32/2024"));
    }

    @Test
    void testRejectDateNov31() {
        assertEquals("", Regex12.date("11/31/2024"));
    }

    @Test
    void testRejectDateMonth13() {
        assertEquals("", Regex12.date("13/31/2024"));
    }

    @Test
    void testRejectDateMonth20() {
        assertEquals("", Regex12.date("20/31/2024"));
    }

}
