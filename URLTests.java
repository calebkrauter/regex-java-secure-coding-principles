/*
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * Trae Claar
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class URLTests {

    // good input

    @Test
    void testAcceptUWWebsite() {
        assertEquals("www.washington.edu", Regex.url("www.washington.edu"));
    }

    @Test
    void testAcceptHTTP() {
        assertEquals("http://www.washington.edu", Regex.url("http://www.washington.edu"));
    }

    @Test
    void testAcceptHTTPS() {
        assertEquals("https://www.washington.edu", Regex.url("https://www.washington.edu"));
    }

    @Test
    void testAcceptTrailingSlash() {
        assertEquals("www.washington.edu/", Regex.url("www.washington.edu/"));
    }

    @Test
    void testAcceptPath() {
        assertEquals("https://www.tacoma.uw.edu/home/about-university-washington-tacoma",
                Regex.url("https://www.tacoma.uw.edu/home/about-university-washington-tacoma"));
    }

    @Test
    void testAcceptInCaps() {
        assertEquals("WWW.WASHINGTON.EDU", Regex.url("WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsHTTP() {
        assertEquals("HTTP://WWW.WASHINGTON.EDU", Regex.url("HTTP://WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsHTTPS() {
        assertEquals("HTTPS://WWW.WASHINGTON.EDU", Regex.url("HTTPS://WWW.WASHINGTON.EDU"));
    }

    @Test
    void testAcceptInCapsPath() {
        assertEquals("HTTP://WWW.WASHINGTON.EDU/ABOUT/", Regex.url("HTTP://WWW.WASHINGTON.EDU/ABOUT/"));
    }

    @Test
    void testAcceptDomainWithTrailingDot() {
        assertEquals("www.washington.edu.", Regex.url("www.washington.edu."));
    }

    // bad input

    @Test
    void testRejectDomainStartsWithDot() {
        assertEquals("", Regex.url(".washington.edu"));
    }

    @Test
    void testRejectDomainStartsWithDotAfterHTTP() {
        assertEquals("", Regex.url("http://.washington.edu"));
    }

    @Test
    void testRejectDomainTwoDots() {
        assertEquals("", Regex.url("www..washington.edu"));
    }

    @Test
    void testRejectDomainContainsNumbers() {
        assertEquals("", Regex.url("www.wash1ngton.edu"));
    }

    @Test
    void testRejectDomainContainsSpecialCharacter() {
        assertEquals("", Regex.url("www.w@shington.edu"));
    }

    @Test
    void testRejectNonHTTPProtocol() {
        assertEquals("", Regex.url("ftp://ftp.something.com"));
    }

    @Test
    void testRejectInvalidProtocol() {
        assertEquals("", Regex.url("//ftp.something.com"));
    }

    @Test
    void testRejectTLDTooShort() {
        assertEquals("", Regex.url("www.washington.e"));
    }
}
