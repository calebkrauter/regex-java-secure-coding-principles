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
    public String ssnRegex(String testInput) {
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

    public String phoneNumberRegex(String testInput) {
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
}

