package contacts;

public class Main {
    public static void main(String[] args) {
        // ContactApp app = new ContactApp();
        // app.run();
        System.out.println(phoneNumberParanthesesAreCorrect("513-748 8522"));
    }

    private static boolean phoneNumberParanthesesAreCorrect(String candidate) {
        // Splits the number into groups either by a space or a dash
        String[] groups = candidate.split("[\\s\\-]");
        // Counts number of parantheses in first group
        int firstGroupParanthesesCount = 0;
        for (char character : groups[0].toCharArray()) {
            if (String.valueOf(character).matches("[()]")) {
                firstGroupParanthesesCount += 1;
            }
        }
        // Counts number of parantheses in second group
        int secondGroupParanthesesCount = 0;
        for (char character : groups[1].toCharArray()) {
            if (String.valueOf(character).matches("[()]")) {
                secondGroupParanthesesCount += 1;
            }
        }
        // First checks if either of the groups has an abnormal number of parentheses - anything either than 2 or 0
        if ((firstGroupParanthesesCount != 2 && firstGroupParanthesesCount != 0) || (secondGroupParanthesesCount != 2 && secondGroupParanthesesCount != 0)) {
            return false;
        } else {
            // Checks if there is not a parenthesis at the start and end of the group,
            // as long as the parentheses count is 2
            if (firstGroupParanthesesCount == 2 && (groups[0].charAt(0) != '(' || groups[0].charAt(groups[0].length() - 1) != ')')) {
                return false;
            }
            if (secondGroupParanthesesCount == 2 && (groups[1].charAt(0) != '(' || groups[1].charAt(groups[1].length() - 1) != ')')) {
                return false;
            }
            // Checks if there are parentheses in either group
            boolean firstGroupCheck = firstGroupParanthesesCount == 2;
            boolean secondGroupCheck = secondGroupParanthesesCount == 2;
            // Will only return false if both groups contain parentheses - a NAND gate
            return !firstGroupCheck || !secondGroupCheck;
        }
    }
}
