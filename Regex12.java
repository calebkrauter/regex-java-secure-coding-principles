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
        String regexPattern = "^(([a-zA-z0-9.'\\- ]{1,99}){1}([,][ ]){1}){1}(([a-zA-z0-9.'\\- ]{1,99}){1}){1}(([,][ ]){1}([a-zA-z0-9.'\\- ]{1}){1}){1,99}$";
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
    
    static public String date(String testInput) {
        String regexPattern = "^(([^00]([0]){1}([0-9]){1})|([1]){1}([0-2]){1}){1}([-]|[/])(([0])([1-9])|([1])([0-9])|([2])([0-9])|([3])([0-1]){1}){1}([-]|[/])([0-9][0-9][0-9][0-9]){1}$";
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
        String regexPattern = "^([a-zA-Z]){1,50}[,][ ]([a-zA-Z]){1,12}[,][ ]([0-9]){1,10}$";
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
        String regexPattern = "^(([0][0-9][0][0]){1}|([1][0-9][0][0]){1}|([2][0-3][0][0]){1})$";
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
        String regexPattern = "^([$]{1})([1-9]){1}(([0-9]{1})?([0-9]{1})([,]([0-9]{1,3})){0,9999999})?([.]([0-9]){1,2})?$";
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
        String regexPattern = "^([h][t][t][p][s]?[:][/][/])?([a-zA-Z\\-0-9]){1,75}([.]{1}[a-zA-Z]{2,99})$";
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
        String regexPattern = "^((?!.*[a-z]{3})([a-zA-Z0-9!]{10,99}))$";
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

