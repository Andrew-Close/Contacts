package contacts;

/**
 * A class which specializes in verifying that a passed phone number is correct.
 */
public class PhoneNumberVerifier {
    /**
     * Checks if the passed String is a valid phone number.
     * Uses helper methods.
     * Both methods must return true for this method to return true.
     * @param candidate the String to check
     * @return a boolean of whether the phone number is correct or not
     */
    public static boolean checkPhoneNumber(String candidate) {
        return phoneNumberParenthesesAreCorrect(candidate) && phoneNumberGroupsAreCorrect(candidate);
    }

    /**
     * Checks if the parentheses in the phone number are correct. The process is explained in the comments.
     * @param candidate the String to check
     * @return a boolean of whether the parentheses are correct or not
     */
    private static boolean phoneNumberParenthesesAreCorrect(String candidate) {
        // Splits the number into groups either by a space or a dash
        String[] groups = candidate.replaceAll("\\+", "").split("[\\s\\-]");
        // Counts number of parentheses in first group
        int firstGroupParenthesesCount = 0;
        for (char character : groups[0].toCharArray()) {
            if (String.valueOf(character).matches("[()]")) {
                firstGroupParenthesesCount += 1;
            }
        }
        // Counts number of parentheses in second group if there is a second group
        int secondGroupParenthesesCount = 0;
        if (groups.length >= 2) {
            for (char character : groups[1].toCharArray()) {
                if (String.valueOf(character).matches("[()]")) {
                    secondGroupParenthesesCount += 1;
                }
            }
        }
        // First checks if either of the groups has an abnormal number of parentheses - anything either than 2 or 0
        if ((firstGroupParenthesesCount != 2 && firstGroupParenthesesCount != 0) || (secondGroupParenthesesCount != 2 && secondGroupParenthesesCount != 0)) {
            return false;
        } else {
            // Checks if there is not a parenthesis at the start and end of the group,
            // as long as the parentheses count is 2
            if (firstGroupParenthesesCount == 2 && (groups[0].charAt(0) != '(' || groups[0].charAt(groups[0].length() - 1) != ')')) {
                return false;
            }
            if (groups.length >= 2) {
                if (secondGroupParenthesesCount == 2 && (groups[1].charAt(0) != '(' || groups[1].charAt(groups[1].length() - 1) != ')')) {
                    return false;
                }
            }
            // Checks if there are parentheses in either group
            boolean firstGroupCheck = firstGroupParenthesesCount == 2;
            boolean secondGroupCheck = secondGroupParenthesesCount == 2;
            // Will only return false if both groups contain parentheses - a NAND gate
            return !firstGroupCheck || !secondGroupCheck;
        }
    }

    /**
     * Checks only the contents of each group, ignoring parentheses in the first and potential second group.
     * @param candidate the String to check
     * @return a boolean of whether the group contents are correct or not
     */
    private static boolean phoneNumberGroupsAreCorrect(String candidate) {
        // Splits the number into groups either by a space or a dash
        String[] groups = candidate.split("[\\s\\-]");
        // Removes all parentheses from first group and second group if it exists,
        // because they are allowed to have parentheses
        groups[0] = groups[0].replaceAll("[()]", "");
        if (groups.length >= 2) {
            groups[1] = groups[1].replaceAll("[()]", "");
        }
        // Checks for validity of the first group
        boolean firstGroup = groups[0].matches("\\+?[a-zA-Z0-9]+");
        // If the first group is invalid, return false immediately
        if (!firstGroup) {
            return false;
        }
        // Checks for validity of each remaining group,
        // or simply returns the check of the first group if there is only one group
        if (groups.length >= 2) {
            for (int i = 1; i < groups.length; i++) {
                if (!groups[i].matches("[a-zA-Z0-9]{2,}")) {
                    return false;
                }
            }
        }
        // true here is firstGroup, it will always be true because false is returned when firstGroup is false
        return true;
    }
}