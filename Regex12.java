import java.util.regex.*;
public class Regex12 {
    public Regex12() {

    }
    // public boolean ssnRegex(String testInput) {
    //     String regexPattern = "^(?![9]|[6]{3}|[0]{3})\\d{3}[ -]?(?![0]{2})\\d{2}[ -]?(?![0]{4})\\d{4}$";
    //     // String testInput = "";
    //     Pattern pattern = Pattern.compile(regexPattern);
    //     Matcher match = pattern.matcher(testInput);
    //     System.out.println(match.matches());
    //     System.out.println(testInput);
    //     return match.matches();
    // }

    public String ssnRegex(String testInput) {
        String regexPattern = "^(?![9]|[6]{3}|[0]{3})\\d{3}[ -]?(?![0]{2})\\d{2}[ -]?(?![0]{4})\\d{4}$";
        // String testInput = "";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher match = pattern.matcher(testInput);
        boolean matchFound = false;
        String resultMatched = "";
        while (match.find()) {
            resultMatched = match.group();
            System.out.print("Matched: " + resultMatched + " with: " + testInput);
            matchFound = true;
            return resultMatched;
        }
        if (!(match.find()) && !matchFound) {
            System.out.println("Couldn't match: " + testInput);
        }
        return "Couldn't match: " + testInput;
    }
}

