
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSSN {
    
    public TestSSN() {

    }

    // REGECT
    // Pass means that there was no match and that the returned string does not match
    // the actual because of the string attatched that says "Couldn't match: "
    @Test//1
    public void testSSNRegectPos1to3Is000() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("000-56-1234")[0], "000-56-1234");
        assertFalse((boolean)testSSN.ssnRegex("000-56-1234")[1]);
    }

    @Test//2
    public void testSSNRegectPos4to5Is00() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("123-00-1234")[0], "123-00-1234");
        assertFalse((boolean)testSSN.ssnRegex("123-00-1234")[1]);
    }

    @Test//3
    public void testSSNRegectPos6to9Is0000() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("123-56-0000")[0], "123-56-0000");
        assertFalse((boolean)testSSN.ssnRegex("123-56-0000")[1]);

    }

    @Test//4
    public void testSSNRegectPos1to3Is666() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("666-56-1234")[0], "666-56-1234");
        assertFalse((boolean)testSSN.ssnRegex("666-56-1234")[1]);

    }
    @Test//5
    public void testSSNRegectContainsNonDigitCharacter() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("6a6-56-1234")[0], "6a6-56-1234");
        assertFalse((boolean)testSSN.ssnRegex("6a6-56-1234")[1]);

    }
    @Test//6
    public void testSSNRegectIncorrectFormat3and3and3() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("123-561-234")[0], "123-561-234");
        assertFalse((boolean)testSSN.ssnRegex("123-561-234")[1]);

    }
    @Test//7
    public void testSSNRegectIncorrectFormat4and2and3() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("1235-61-234")[0], "1235-61-234");
        assertFalse((boolean)testSSN.ssnRegex("1235-61-234")[1]);
    }
    @Test//8
    public void testSSNRegectIncorrectFormat3and1and5() {
        Regex12 testSSN = new Regex12();
        assertNotEquals(testSSN.ssnRegex("123-5-61234")[0], "123-5-61234");
        assertFalse((boolean)testSSN.ssnRegex("123-5-61234")[1]);

    }
    // ALLOW
    @Test
    public void testSSNAllowValidSSN() {
        Regex12 testSSN = new Regex12();
        assertEquals(testSSN.ssnRegex("100-56-1234")[0], "100-56-1234");
        assertTrue((boolean)testSSN.ssnRegex("100-56-1234")[1]);

    }

}
