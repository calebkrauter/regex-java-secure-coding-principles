
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * @author Caleb Krauter
 */


public class TestSSN{

    // Reject
    // Pass means that there was no match and that the returned string does not match
    // the actual because of the string attatched that says "Couldn't match: "
    @Test//1
    public void testSSNRejectPos1to3Is000() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("000-56-1234"));
        assertEquals("", test12Regex.ssnRegex("123-00-1234"));

    }

    @Test//2
    public void testSSNRejectPos4to5Is00() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("123-00-1234"));
    }

    @Test//3
    public void testSSNRejectPos6to9Is0000() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("123-56-0000"));
    }

    @Test//4
    public void testSSNRejectPos1to3Is666() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("666-56-1234"));

    }
    @Test//5
    public void testSSNRejectPos1Is9() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("966-56-1234"));

    }
    @Test//6
    public void testSSNRejectContainsNonDigitCharacter() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("1a3-56-1234"));
    }
    @Test//7
    public void testSSNRejectIncorrectFormat3and3and3() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("123-561-234"));
    }
    @Test//8
    public void testSSNRejectIncorrectFormat4and1and3() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("12356-1-234"));
    }
    @Test//9
    public void testSSNRejectIncorrectFormat3and1and5() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("123-5-61234"));
    }
    @Test//10
    public void testSSNRejectValuesOutsideOfSsn() {
        Regex12 test12Regex= new Regex12();
        assertEquals("", test12Regex.ssnRegex("1123-52-612343"));
    }
    // ALLOW
    @Test//1
    public void testSSNAllowValidSSNContains1Through8And0() {
        Regex12 test12Regex= new Regex12();
        assertEquals("123-45-6780", test12Regex.ssnRegex("123-45-6780"));
    }
    @Test//2
    public void testSSNAllowValidSSNContains1Through9() {
        Regex12 test12Regex= new Regex12();
        assertEquals("123-45-6789", test12Regex.ssnRegex("123-45-6789"));
    }
    @Test//3
    public void testSSNAllowValidSSNWithNoDashes() {
        Regex12 test12Regex= new Regex12();
        assertEquals("123456789", test12Regex.ssnRegex("123456789"));
    }
    @Test//4
    public void testSSNAllowValidSSNWithOneDashBetweenPos5And6() {
        Regex12 test12Regex= new Regex12();
        assertEquals("12345-6789", test12Regex.ssnRegex("12345-6789"));
    }
    @Test//5
    public void testSSNAllowValidSSNWithOneDashBetweenPos3And4() {
        Regex12 test12Regex= new Regex12();
        assertEquals("123-456789", test12Regex.ssnRegex("123-456789"));
    }
    @Test//6
    public void testSSNAllowValidSSNContains666AtPos7To9() {
        Regex12 test12Regex= new Regex12();
        assertEquals("123-45-5666", test12Regex.ssnRegex("123-45-5666"));
    }
    @Test//7
    public void testSSNAllowValidSSNContainsOnly6ExceptPos1() {
        Regex12 test12Regex= new Regex12();
        assertEquals("166-66-6666", test12Regex.ssnRegex("166-66-6666"));
    }
    @Test//8
    public void testSSNAllowValidSSNContainsAll0ExceptTheFirstOfEachSection() {
        Regex12 test12Regex= new Regex12();
        assertEquals("100-10-1000", test12Regex.ssnRegex("100-10-1000"));
    }
    @Test//9
    public void testSSNAllowValidSSNContainsAll2AndNoDashes() {
        Regex12 test12Regex= new Regex12();
        assertEquals("222222222", test12Regex.ssnRegex("222222222"));
    }
    @Test//10
    public void testSSNAllowValidSSNContainsAll3WithDashes() {
        Regex12 test12Regex= new Regex12();
        assertEquals("333-33-3333", test12Regex.ssnRegex("333-33-3333"));
    }

}
