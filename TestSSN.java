
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSSN {
    
    public TestSSN() {

    }
    // @Test
    // public void testSSNRegectPos1to3Is000() {
    //     Regex12 testSSN = new Regex12();
    //     assertFalse( testSSN.ssnRegex("000-56-1234"));
    // }

    // @Test
    // public void testSSNRegectPos4to5Is00() {
    //     Regex12 testSSN = new Regex12();
    //     assertFalse( testSSN.ssnRegex("100-00-5855"));
    // }

    // @Test
    // public void testSSNRegectPos6to9Is0000() {
    //     Regex12 testSSN = new Regex12();
    //     assertFalse( testSSN.ssnRegex("100-56-0000"));
    // }
    // @Test
    // public void testSSNAllowValidSSN() {
    //     Regex12 testSSN = new Regex12();
    //     assertTrue(testSSN.ssnRegex("100-56-1234"));
    // }

    @Test
    public void testSSNRegectPos1to3Is000() {
        Regex12 testSSN = new Regex12();
        assertEquals(testSSN.ssnRegex("000-56-1234"), "000-56-1234");
    }
}
