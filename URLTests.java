/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar and (modified) by Caleb Krauter
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class URLTests {

    // good input

    @Test
    void testAcceptUWWebsite() {
        assertEquals("www.washington.edu", Regex12.url("www.washington.edu"));
    }

    @Test
    void testAcceptHTTP() {
        assertEquals("http://www.washington.edu", Regex12.url("http://www.washington.edu"));
    }

    @Test
    void testAcceptHTTPS() {
        assertEquals("https://www.washington.edu", Regex12.url("https://www.washington.edu"));
    }

    @Test
    void testAcceptTrailingSlash() {
        assertEquals("www.washington.edu/", Regex12.url("www.washington.edu/"));
    }

    @Test
    void testAcceptPath() {
        assertEquals("https://www.tacoma.uw.edu/home/about-university-washington-tacoma",
                Regex12.url("https://www.tacoma.uw.edu/home/about-university-washington-tacoma"));
    }

    @Test
    void testAcceptInCaps() {
        assertEquals("WWW.WASHINGTON.EDU", Regex12.url("WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsHTTP() {
        assertEquals("HTTP://WWW.WASHINGTON.EDU", Regex12.url("HTTP://WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsHTTPS() {
        assertEquals("HTTPS://WWW.WASHINGTON.EDU", Regex12.url("HTTPS://WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsPath() {
        assertEquals("HTTP://WWW.WASHINGTON.EDU/ABOUT/", Regex12.url("HTTP://WWW.WASHINGTON.EDU/ABOUT/"));
    }

    @Test
    void testAcceptDomainWithTrailingDot() {
        assertEquals("www.washington.edu.", Regex12.url("www.washington.edu."));
    }

    // bad input

    @Test
    void testRejectDomainStartsWithDot() {
        assertEquals("", Regex12.url(".washington.edu"));
    }

    @Test
    void testRejectDomainStartsWithDotAfterHTTP() {
        assertEquals("", Regex12.url("http://.washington.edu"));
    }

    @Test
    void testRejectDomainContainsNumbers() {
        assertEquals("", Regex12.url("www.wash1ngton.edu"));
    }

    @Test
    void testRejectDomainContainsSpecialCharacter() {
        assertEquals("", Regex12.url("www.w@shington.edu"));
    }

    @Test
    void testRejectNonHTTPProtocol() {
        assertEquals("", Regex12.url("ftp://ftp.something.com"));
    }

    @Test
    void testRejectInvalidProtocol() {
        assertEquals("", Regex12.url("protocol://www.tacoma.uw.edu/home/about-university-washington-tacoma"));
    }

    @Test
    void testRejectTLDTooShort() {
        assertEquals("", Regex12.url("www.washington.e"));
    }
}
