package contacts;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.time.LocalDate;

import static contacts.AppMessages.*;

/**
 * The actual app. Everything run is contained in here.
 */
public class ContactApp implements Runnable {
    /**
     * An enum for keeping track of valid actions.
     */
    private enum Actions {
        ADD("add"), REMOVE("remove"), EDIT("edit"), COUNT("count"), LIST("list"), EXIT("exit");

        private final String action;

        Actions(String action) {
            this.action = action;
        }

        private String getAction() {
            return this.action;
        }
    }

    /**
     * An enum for keeping track of valid fields.
     */
    private enum Fields {
        NAME("name"), SURNAME("surname"), NUMBER("number");

        private final String field;

        Fields(String field) {
            this.field = field;
        }

        private String getField() {
            return this.field;
        }
    }

    /**
     * An enum for keeping track of valid types.
     */
    private enum Types {
        PERSON("person"), ORGANIZATION("organization");

        private String type;

        Types(String type) { this.type = type; }

        private String getType() {
            return type;
        }
    }

    /**
     * An enum for keeping track of valid genders.
     */
    private enum Genders {
        M("M"), F("F");

        private String gender;

        Genders(String gender) { this.gender = gender; }

        private String getGender() {
            return gender;
        }
    }

    private static final List<Contact> CONTACTS = new ArrayList<>();

    @Override
    public void run() {
        while (true) {
            System.out.print(MAIN_MENU_QUERY);
            Actions action = UserInput.getValidAction();
            executeAction(action);
        }
    }

    /**
     * Takes an action and executes the corresponding method.
     * @param action the action to be executed
     */
    private void executeAction(Actions action) {
        switch (action) {
            case ADD:
                addRecord();
                break;
            case REMOVE:
                removeRecord();
                break;
            case EDIT:
                editRecord();
                break;
            case COUNT:
                countRecords();
                break;
            case LIST:
                listRecords();
                break;
            case EXIT:
                System.exit(0);
            default:
                System.out.println(INVALID_PASSED_ACTION);
        }
    }

    /**
     * Adds a record to the contact list. Gets user input to do so.
     */
    private void addRecord() {
        Scanner scanner = new Scanner(System.in);
        //Type
        System.out.println(ENTER_TYPE_QUERY);
        Types type = UserInput.getValidType();
        //Person
        if (type.equals(Types.PERSON)) {
            //Name
            System.out.print(ENTER_NAME_QUERY);
            String name = scanner.nextLine();

            //Surname
            System.out.print(ENTER_SURNAME_QUERY);
            String surname = scanner.nextLine();

            //Birthdate
            System.out.println(ENTER_BIRTHDATE_QUERY);
            Optional<LocalDate> birthDate = UserInput.getAndVerifyBirthDate();

            //Gender
            System.out.println(ENTER_GENDER_QUERY);
            Optional<Genders> gender = UserInput.getAndVerifyGender();

            //Number
            System.out.print(ENTER_NUMBER_QUERY);
            String number = scanner.nextLine();

            String stringBirthDate = birthDate.isPresent() ? birthDate.get().toString() : "[no data]";
            String stringGender = gender.isPresent() ? gender.get().getGender() : "[no data]";

            CONTACTS.add(new PersonContact(number, name, surname, stringBirthDate, stringGender));
        //Organization
        } else {
            //Organization name
            System.out.println(ENTER_ORGNAME_QUERY);
            String organizationName = scanner.nextLine();

            //Address
            System.out.println(ENTER_ADDRESS_QUERY);
            String address = scanner.nextLine();

            //Number
            System.out.print(ENTER_NUMBER_QUERY);
            String number = scanner.nextLine();

            CONTACTS.add(new OrganizationContact(number, organizationName, address));
        }
        System.out.println(RECORD_ADDED);
    }

    /**
     * Removes a record based on an index from user input, or states that there are no records to remove.
     */
    private void removeRecord() {
        if (CONTACTS.isEmpty()) {
            System.out.println(NO_RECORDS_TO_REMOVE);
        } else {
            listRecords();
            System.out.print(SELECT_RECORD_QUERY);
            int index = UserInput.getValidRecordSelection();
            CONTACTS.remove(index);
            System.out.println(RECORD_REMOVED);
        }
    }

    /**
     * Edits one field of a record, both specified via user input.
     */
    private void editRecord() {
        if (CONTACTS.isEmpty()) {
            System.out.println(NO_RECORDS_TO_EDIT);
        } else {
            listRecords();
            System.out.print(SELECT_RECORD_QUERY);
            int index = UserInput.getValidRecordSelection();

            System.out.print(SELECT_FIELD_QUERY);
            Fields field = UserInput.getValidField();

            editField(index, field);
            System.out.println(RECORD_UPDATED);
        }
    }

    /**
     * Edits the passed field of the contact at the passed index.
     * @param index the index of the contact to edit
     * @param field the field to edit
     */
    private void editField(int index, Fields field) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = CONTACTS.get(index);
        switch (field) {
            case NAME:
                System.out.print(ENTER_NAME_QUERY);
                String name = scanner.nextLine();
                contact.setName(name);
                break;
            case SURNAME:
                System.out.print(ENTER_SURNAME_QUERY);
                String surname = scanner.nextLine();
                contact.setSurname(surname);
                break;
            case NUMBER:
                System.out.print(ENTER_NUMBER_QUERY);
                String number = scanner.nextLine();
                contact.setPhoneNumber(number);
                break;
        }
    }

    /**
     * Prints how many records there are in the contact list, even if there are no records.
     */
    private void countRecords() {
        System.out.printf(COUNT_FORMAT + "%n", CONTACTS.size());
    }

    /**
     * Lists all records in the contact list, or states that there are no records to list.
     */
    private void listRecords() {
        if (CONTACTS.isEmpty()) {
            System.out.println(NO_RECORDS_TO_LIST);
        } else {
            // Format is Index + 1. Name Surname, Phone number
            CONTACTS.forEach(x -> System.out.println(CONTACTS.indexOf(x) + 1 + ". " + x.getName() + " " + x.getSurname() + ", " + x.getPhoneNumber()));
        }
    }


    /**
     * A class for getting valid user input for the contact app.
     */
    private static class UserInput {
        /**
         * Gets a valid action from user input to be used on the main menu screen.
         * @return the action to be used
         */
        private static Actions getValidAction() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String possibleAction = scanner.nextLine();
                for (Actions action : Actions.values()) {
                    if (possibleAction.equalsIgnoreCase(action.getAction())) {
                        return action;
                    }
                }
                System.out.print(INVALID_ACTION_QUERY);
            }
        }

        /**
         * Gets a valid record index from user input to be used when selecting a record to be removed or edited.
         * @return the record index
         */
        private static int getValidRecordSelection() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                int index = scanner.nextInt() - 1;
                if (index < 0 || index >= CONTACTS.size()) {
                    System.out.print(INVALID_RECORD_SELECTION_QUERY);
                } else {
                    return index;
                }
            }
        }

        /**
         * Gets a valid field from user input using the fields enum to be used for editing records.
         * @return the valid field from user input
         */
        private static Fields getValidField() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String possibleField = scanner.nextLine();
                for (Fields field : Fields.values()) {
                    if (possibleField.equalsIgnoreCase(field.getField())) {
                        return field;
                    }
                }
                System.out.print(INVALID_FIELD_QUERY);
            }
        }

        private static Types getValidType() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String possibleType = scanner.nextLine();
                for (Types type : Types.values()) {
                    if (possibleType.equalsIgnoreCase(type.getType())) {
                        return type;
                    }
                }
                System.out.print(INVALID_TYPE_QUERY);
            }
        }

        private static Optional<LocalDate> getAndVerifyBirthDate() {
            Scanner scanner = new Scanner(System.in);
            String possibleDate = scanner.nextLine();
            try {
                return Optional.of(LocalDate.parse(possibleDate));
            } catch (DateTimeParseException e) {
                System.out.println(INVALID_BIRTHDATE);
                return Optional.empty();
            }
        }

        private static Optional<Genders> getAndVerifyGender() {
            Scanner scanner = new Scanner(System.in);
            String possibleGender = scanner.nextLine();
            for (Genders gender : Genders.values()) {
                if (possibleGender.equalsIgnoreCase(gender.getGender())) {
                    return Optional.of(gender);
                }
            }
            System.out.print(INVALID_GENDER);
            return Optional.empty();
        }
    }


    /**
     * A class which is responsible for checking phone numbers and making sure they are valid.
     */
    static class PhoneNumberVerifier {
        /**
         * Checks if the passed String is a valid phone number.
         * Uses helper methods.
         * Both methods must return true for this method to return true.
         * @param candidate the String to check
         * @return a boolean of whether the phone number is correct or not
         */
        static boolean checkPhoneNumber(String candidate) {
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
}
