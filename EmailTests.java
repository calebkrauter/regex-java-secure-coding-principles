/**
 * Individual Assignment - Regular Expressions
 * TCSS 483
 * @author Trae Claar and (modified) by Caleb Krauter
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTests {

    // good input

    @Test
    void testAcceptValid() {
        assertEquals("example@something.com", Regex12.emailAddress("example@something.com"));
    }

    @Test
    void testAccept3CharacterUsername() {
        assertEquals("eaa@something.com", Regex12.emailAddress("eaa@something.com"));
    }

    @Test
    void testAcceptManySpecialCharactersUsername() {
        assertEquals("user~!%$^&*_=+@something.com",
                Regex12.emailAddress("user~!%$^&*_=+@something.com"));
    }

    @Test
    void testAcceptUsernameWithNumbers() {
        assertEquals("example22@something.com", Regex12.emailAddress("example22@something.com"));
    }

    @Test
    void testAcceptLongDomain() {
        assertEquals("example22@somaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaething.com", Regex12.emailAddress("example22@somaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaething.com"));
    }

    @Test
    void testAccept1CharacterDomain() {
        assertEquals("example@a.com", Regex12.emailAddress("example@a.com"));
    }

    @Test
    void testAcceptNumbersInDomain() {
        assertEquals("example@s0m3th1ng.com", Regex12.emailAddress("example@s0m3th1ng.com"));
    }

    @Test
    void testAccept2CharacterTopLevelDomain() {
        assertEquals("example@something.co", Regex12.emailAddress("example@something.co"));
    }
    @Test
    void testAcceptMultipleSubDomainsAndCustomTopLevelDomainNotCapsSensitive() {
        assertEquals("DoYouKnowMe?@I.Need.You.To.Save.Me.Please.helPMe", Regex12.emailAddress("DoYouKnowMe?@I.Need.You.To.Save.Me.Please.helPMe"));
    }

    // bad input

    @Test
    void testRejectDomainStartWithSpecialCharacter() {
        assertEquals("", Regex12.emailAddress(".example@.something.com"));
    }

    @Test
    void testRejectDomainEndWithSpecialCharacter() {
        assertEquals("", Regex12.emailAddress("example.@something!.com"));
    }

    @Test
    void testRejectDomainWithSpecialCharacters() {
        assertEquals("", Regex12.emailAddress("example.@somet$#@hing!.com"));
    }

    @Test
    void testRejectDoubleSpecialCharacterInDomain() {
        assertEquals("", Regex12.emailAddress("example@some.!thing.com"));
    }

    @Test
    void testRejectNoUsername() {
        assertEquals("", Regex12.emailAddress("@something.com"));
    }

    @Test
    void testRejectNoDomain() {
        assertEquals("", Regex12.emailAddress("example@.com"));
    }

    @Test
    void testRejectNoTopLevelDomain() {
        assertEquals("", Regex12.emailAddress("example@something"));
    }

    @Test
    void testRejectNoAt() {
        assertEquals("", Regex12.emailAddress("examplesomething.com"));
    }

    @Test
    void testRejectSpecialCharacterInTopLevelDomain() {
        assertEquals("", Regex12.emailAddress("example@something.*om"));
    }

    @Test
    void testRejectDigitInTopLevelDomain() {
        assertEquals("", Regex12.emailAddress("example@something.c0m"));
    }

    @Test
    void testRejectNoTopLevelDomainWithAppendedDecimal() {
        assertEquals("", Regex12.emailAddress("example@something."));
    }
}
