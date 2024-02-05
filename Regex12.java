import java.time.Year;
import java.util.regex.*;
/**
 * Implement Regex for each scenario. Used Regexr.com for designing Regular Expressions and some of my tests.
 * @author Caleb Krauter
 */
public class Regex12 {
    public Regex12() {

    }

    /**
     * Checks the match found of the input for the Regex. If "" is returned than no match was found.
     * @param testInput
     * @return
     */
    static public String ssnRegex(String testInput) {
        String regexPattern = "^(?![9]|[6]{3}|[0]{3})\\d{3}[ -]?(?![0]{2})\\d{2}[ -]?(?![0]{4})\\d{4}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        // Check for a match.
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments for a phone number in the US.
     * @param testInput a phone number.
     * @return the result.
     */
    static public String phoneNumberRegex(String testInput) {
        String regexPattern = "^([+]\\d{1}?[-])?(([(]\\d{3}[)])|(\\d{3}))[ -]?\\d{3}?[ -]?\\d{4}?$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments for an email address.
     * @param testInput a email address.
     * @return the result.
     */
    static public String emailAddress(String testInput) {
        String regexPattern = "^([a-zA-Z0-9~!$%^&*_=+}{'?\\-.]){2,99}[@]{1}([a-zA-Z0-9]){1,255}[.]{1}((([a-zA-Z0-9]){1,63}[.]{1}){1,500})?((([c][o][m]){1})|(([a-zA-Z]){1,15}))$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }
    
    /**
     * Checks that the test input matches the requirments name on a roster.
     * @param testInput a name on a roster.
     * @return the result.
     */
    static public String nameOnRoster(String testInput) {
        String regexPattern = "^(([A-Z.'\\- ]{1}[a-zA-Z.'\\- ]{0,99}){1}([,][ ]){1}){1}(([A-Z.'\\- ]{1}[a-zA-Z.'\\- ]{0,99}){1}){1}(([,][ ]){1}(([A-Z.'\\- ]{1,99}){1}){1,99})?$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * A helper method used to format the date of the month and year from something like
     * month: 02 and year: 0233 to month: 2 and year: 233. This makes it easier to 
     * check what month it is and also use Java's library for checking if there is a leap year.
     * @param characters contains data for the date.
     * @return an Object array of the month and year formatted.
     */
    static private Object[] helpDate(char[] characters) {
        int theMonth = 0;
        int theYear = 0;
        // Use a try catch to ensure no errors go uncaught.
        try {
            // When a date is formatted such as 02-04-0881
            // it should be broken apart at the separators and
            // the 0s that preceed the rest of the digits should be
            // removed.
            for (int i = 0; i < characters.length; i++) {
                // For the first two positions we have a month which needs to be parsed and formatted.
                if (i <= 1 && (characters[i] != '/' && characters[i] !='-')) {
                    if (theMonth == 0) {
                        theMonth = Integer.parseInt(String.valueOf(characters[i]));
                    } else {
                        theMonth = theMonth * 10 + Integer.parseInt(String.valueOf(characters[i]));
                    }   
                // For the first last four positions we have a year which needs to be parsed and formatted. 
                } else if (i <= 9 && (characters[i] != '/' && characters[i] !='-')) {
                    // Check that the first digit of the year is 0 and handle that situation.
                    // Note this may not work for years lesser than 0100
                    if (characters[6] == 0 && i == 5) {
                        theYear = theYear % 1000;
                    } else {
                        // Format the year to rid of the unnecessary preceeding 0.
                        theYear = theYear * 10 + Integer.parseInt(String.valueOf(characters[i]));
                    }
                }
            }
        } catch (Exception e) {
            return new Object[]{0, 0};
        }
        return new Object[]{theMonth, theYear};
    }

    /**
     * Checks that the test input matches the requirments of a valid date.
     * @param testInput a date with either / or - as seperators.
     * @return the result.
     */
    static public String date(String testInput) {
        String temp = testInput;
        char[] characters = temp.toCharArray();
        Object[] monthAndYear = helpDate(characters);
        int theMonth = (int) monthAndYear[0];
        int theYear = (int) monthAndYear[1];
        System.out.println("The month is " + theMonth);
        System.out.println("The year is " + theYear);
        // Adjusts using Java's library for leap year.

        String regexPattern;
        // Update the regex depending upon the month and leapyear to ensure date validitity.
        if (theMonth == 4 || theMonth == 6 || theMonth == 9 || theMonth == 11) {
            System.out.println("ENTER");
            regexPattern = "^((([0]){1}([1-9]){1})|([1]){1}([0-2]){1}){1}([-]|[/])(([0])([1-9])|([1])([0-9])|([2])([0-9])|([3])([0]){1}){1}([-]|[/])([0-9][0-9][0-9][0-9]){1}$";
        } else if (theMonth == 2) {
            if (Year.isLeap(theYear)) {
                regexPattern = "^((([0]){1}([1-9]){1})|([1]){1}([0-2]){1}){1}([-]|[/])(([0])([1-9])|([1])([0-9])|([2])([0-9]){1}){1}([-]|[/])([0-9][0-9][0-9][0-9]){1}$";
            }
            else {
                regexPattern = "^((([0]){1}([1-9]){1})|([1]){1}([0-2]){1}){1}([-]|[/])(([0])([1-9])|([1])([0-9])|([2])([0-8]){1}){1}([-]|[/])([0-9][0-9][0-9][0-9]){1}$";
            }
        } else { // theMonth == (1 | 3 | 5 | 7 | 8 | 10 | 12) or the date is invalid and will be checked against the broadest regex.
            regexPattern = "^((([0]){1}([1-9]){1})|([1]){1}([0-2]){1}){1}([-]|[/])(([0])([1-9])|([1])([0-9])|([2])([0-9])|([3])([0-1]){1}){1}([-]|[/])([0-9][0-9][0-9][0-9]){1}$";
        }
        // For debugging.
        System.out.println("The Regex is " + regexPattern.toString());
        System.out.println("input: " + testInput);

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }
    
    /**
     * Checks that the test input matches the requirments for a house address.
     * @param testInput a house address.
     * @return the result.
     */
    static public String houseAddress(String testInput) {
        String regexPattern = "^([0-9]){1,10}[,]?[ ]([0-9a-zA-Z]){1,99}[,]?[ ]([a-zA-Z ]){1,99}$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }
    
    /**
     * Checks that the test input matches the requirments for a city address.
     * @param testInput a city address.
     * @return the result.
     */
    static public String extendedAddress(String testInput) {
        String regexPattern = "^([a-zA-Z ]){1,50}[,][ ]([A-Z]){1,12}[,]?[ ]([0-9]){5}([-]([0-9]{1,4}))?$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }
    
    /**
     * Checks that the test input matches the requirments for a city address.
     * @param testInput a city address.
     * @return the result.
     */
    static public String militaryTime(String testInput) {
        String regexPattern = "^(([0][0-9][0-5][0-9]){1}|([1][0-9][0-5][0-9]){1}|([2][0-3][0-5][0-9]){1})$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments for USD.
     * @param testInput a USD amount.
     * @return the result.
     */
    static public String usCurrency(String testInput) {
        String regexPattern = "^([$]{1})(([1-9]){1})?(([0-9]{1})?([0-9]{1})([,]([0-9]{3})){0,9999999})?([.]([0-9]){1,2})$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments a url.
     * @param testInput a url.
     * @return the result.
     */
    static public String url(String testInput) {
        String regexPattern = "^((?i)([h][t][t][p][s]?){1}([:][/][/]){1})?([a-zA-Z\\-0-9/\\-]){1,75}(([.][^com][a-zA-Z/\\-]{1,99}){0,10})?([.]{1}[a-zA-Z]{2,99})?([/]{1})?([.]{1})?$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments a password.
     * @param testInput a password.
     * @return the result.
     */
    static public String password(String testInput) {
        String regexPattern = "^((?!.*[a-z]{4})((?=.*[a-z]{1,99})(?=.*[A-Z]{1,99})(?=.*[!.,@#$%^&*()=+\\-f/?~`'\";:]{1,99})(?=.*[0-9]{1,99})){10,99}).*$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            return resultMatched;
        }
        // No match found so output an empty Stirng.
        return "";
    }

    /**
     * Checks that the test input matches the requirments for matching words that
     * have an odd number of characters and end in "ion".
     * @param testInput a String of a/multiple word(s).
     * @return the result.
     */
    static public String wordsContainingOddNumOfAlphabeticalCharactersEndingInIon(String testInput) {
        String regexPattern = "((\\b([a-zA-Z]{2})*([i][o][n])\\b){1,99})";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        String resultMatched = "";
        String addUpMatches = "";
        boolean matchFound = false;
        while (match.find()) {
            resultMatched = match.group();
            // Make sure to test match of multiple words that meet requirement.
            if (addUpMatches == "") {
                addUpMatches = resultMatched;
            } else {
                addUpMatches += " " + resultMatched;
            }
            matchFound = true;
        }
        if (match.find() == false && matchFound == true) {
            System.out.print("Matched: " + addUpMatches + " with: " + testInput);

            return addUpMatches;
        }
        // No match found so output an empty Stirng.
        return "";
    }
}

