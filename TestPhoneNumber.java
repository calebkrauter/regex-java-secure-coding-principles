import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
/**
 * @author Caleb Krauter
 */

public class TestPhoneNumber {

    // Reject
    @Test//1
    public void testPhoneNumberRejectFirstValueIsDashWithNoPlus1() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("-(253)-555-5555"));
    }
    @Test//2
    public void testPhoneNumberRejectContainsLeftParenthesisAndNotRight() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("(253-555-5555"));
    }
    @Test//3
    public void testPhoneNumberRejectContainsRightParenthesisAndNotLeft() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("253)-555-5555"));
    }
    @Test//4
    public void testPhoneNumberRejectPhoneNumberToLarge() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("253-555-55555"));
    }
    @Test//5
    public void testPhoneNumberRejectPhoneNumberToLargeNoDashes() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("25355555555"));
    }
    @Test//6
    public void testPhoneNumberRejectValueFoundPreceedingPlus1() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("5+1-253-555-5555"));
    }
    @Test//7
    public void testPhoneNumberRejectContainsAnAlphabeticalCharacter() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("25P-555-5555"));
    }
    @Test//8
    public void testPhoneNumberRejectFoundDashOrMultipleInIncorrectLocations() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.phoneNumberRegex("25355-55555"));
    }

    // Allow
    @Test//1
    public void testPhoneNumberAllowFirstValueIsDashWithPlus1() {
        Regex12 test12Regex= new Regex12();
        assertEquals("+1-(253)-555-5555", test12Regex.phoneNumberRegex("+1-(253)-555-5555"));
    }
    @Test//2
    public void testPhoneNumberAllowNoDashes() {
        Regex12 test12Regex= new Regex12();
        assertEquals("2535555555", test12Regex.phoneNumberRegex("2535555555"));
    }
    @Test//3
    public void testPhoneNumberAllowOneDashAfterPos3() {
        Regex12 test12Regex= new Regex12();
        assertEquals("253-5555555", test12Regex.phoneNumberRegex("253-5555555"));
    }
    @Test//4
    public void testPhoneNumberAllowOneDashAfterPos6() {
        Regex12 test12Regex= new Regex12();
        assertEquals("253555-5555", test12Regex.phoneNumberRegex("253555-5555"));
    }
    @Test//5
    public void testPhoneNumberAllowParenthesisWithNoPlusOneAndDash() {
        Regex12 test12Regex= new Regex12();
        assertEquals("(253)-555-5555", test12Regex.phoneNumberRegex("(253)-555-5555"));
    }
    @Test//6
    public void testPhoneNumberAllow0Through9() {
        Regex12 test12Regex= new Regex12();
        assertEquals("(012)-345-6789", test12Regex.phoneNumberRegex("(012)-345-6789"));
    }
    @Test//7
    public void testPhoneNumberAllowDashesAndNoParenthesis() {
        Regex12 test12Regex= new Regex12();
        assertEquals("253-555-5555", test12Regex.phoneNumberRegex("253-555-5555"));
    }
    @Test//8
    public void testPhoneNumberAllowNoDashesAndPlusOneAndSingleDashAtStart() {
        Regex12 test12Regex= new Regex12();
        assertEquals("+1-2535555555", test12Regex.phoneNumberRegex("+1-2535555555"));
    }
}
