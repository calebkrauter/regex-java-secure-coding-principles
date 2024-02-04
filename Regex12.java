import java.time.Year;
import java.time.YearMonth;
import java.util.regex.*;
/**
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
        // String testInput = "";
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

    static public String phoneNumberRegex(String testInput) {
        String regexPattern = "^([+]\\d{1}?[-])?(([(]\\d{3}[)])|(\\d{3}))[ -]?\\d{3}?[ -]?\\d{4}?$";
        // String testInput = "";
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
    
    static public String emailAddress(String testInput) {
        String regexPattern = "^([a-zA-Z0-9~!$%^&*_=+}{'?\\-.]){2,99}[@]{1}([a-zA-Z0-9]){1,255}[.]{1}((([a-zA-Z0-9]){1,63}[.]{1}){1,500})?((([c][o][m]){1})|(([a-zA-Z]){1,15}))$";
        // String testInput = "";
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
    
    static public String nameOnRoster(String testInput) {
        String regexPattern = "^(([A-Z.'\\- ]{1}[a-zA-Z.'\\- ]{0,99}){1}([,][ ]){1}){1}(([A-Z.'\\- ]{1}[a-zA-Z.'\\- ]{0,99}){1}){1}(([,][ ]){1}(([A-Z.'\\- ]{1,99}){1}){1,99})?$";
        // String testInput = "";
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
    //00/00/0000
    static public String date(String testInput) {
        String temp = testInput;
        char[] characters = temp.toCharArray();
        int theMonth = 0;
        int theDay = 0;
        int theYear = 0;
        try {
            for (int i = 0; i < characters.length; i++) {
                if (i <= 1 && (characters[i] != '/' && characters[i] !='-')) {
                    if (theMonth == 0) {
                        theMonth = Integer.parseInt(String.valueOf(characters[i]));
                    } else {
                        theMonth = theMonth * 10 + Integer.parseInt(String.valueOf(characters[i]));
                    }
                    // System.out.println("The month is " + theMonth);
    
                } else if (i <= 4 && (characters[i] != '/' && characters[i] !='-')) {
                    // System.out.println(characters[i]);
    
                    if (theDay == 0) {
                        theDay = Integer.parseInt(String.valueOf(characters[i]));
                    } else {
                        theDay = theDay * 10 + Integer.parseInt(String.valueOf(characters[i]));
                    }
                    // System.out.println("The day is " + theDay);
                } else if (i <= 9 && (characters[i] != '/' && characters[i] !='-')) {
                    // System.out.println(characters[i]);
    
                    if (characters[6] == 0 && i == 5) {
                        theYear = theYear % 1000;
                    } else {
                        theYear = theYear * 10 + Integer.parseInt(String.valueOf(characters[i]));
                    }
                }
            }
        } catch (Exception e) {
            return "";
        }
        
        System.out.println("The month is " + theMonth);

        System.out.println("The Day is " + theDay);
        // System.out.println(theMonth);
        // System.out.println(theYear);
       
        // Adjusts using Java's library for leap year.

        String regexPattern;
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
        System.out.println("The Regex is " + regexPattern.toString());
        System.out.println("input: " + testInput);
        // String testInput = "";
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
    
    static public String houseAddress(String testInput) {
        String regexPattern = "^([0-9]){1,10}[,]?[ ]([0-9a-zA-Z]){1,99}[,]?[ ]([a-zA-Z ]){1,99}$";
        // String testInput = "";
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
    
    static public String extendedAddress(String testInput) {
        String regexPattern = "^([a-zA-Z ]){1,50}[,][ ]([A-Z]){1,12}[,]?[ ]([0-9]){5}([-]([0-9]{1,4}))?$";
        // String testInput = "";
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
    
    static public String militaryTime(String testInput) {
        String regexPattern = "^(([0][0-9][0-5][0-9]){1}|([1][0-9][0-5][0-9]){1}|([2][0-3][0-5][0-9]){1})$";
        // String testInput = "";
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

    
    static public String usCurrency(String testInput) {
        String regexPattern = "^([$]{1})(([1-9]){1})?(([0-9]{1})?([0-9]{1})([,]([0-9]{3})){0,9999999})?([.]([0-9]){1,2})$";
        // String testInput = "";
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

        
    static public String url(String testInput) {
        String regexPattern = "^((?i)([h][t][t][p][s]?){1}([:][/][/]){1})?([a-zA-Z\\-0-9/\\-]){1,75}(([.][^com][a-zA-Z/\\-]{1,99}){0,10})?([.]{1}[a-zA-Z]{2,99})?([/]{1})?([.]{1})?$";
        // String testInput = "";
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

        
    static public String password(String testInput) {
        String regexPattern = "^((?!.*[a-z]{4})((?=.*[a-z]{1,99})(?=.*[A-Z]{1,99})(?=.*[!.,@#$%^&*()=+\\-f/?~`'\";:]{1,99})(?=.*[0-9]{1,99})){10,99}).*$";
        // String testInput = "";
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

        
    static public String wordsContainingOddNumOfAlphabeticalCharactersEndingInIon(String testInput) {
        String regexPattern = "((\\b([a-zA-Z]{2})*([i][o][n])\\b){1,99})";
        // String testInput = "";
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
}

