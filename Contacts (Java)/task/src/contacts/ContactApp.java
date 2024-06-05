package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    private static final List<Contact> CONTACTS = new ArrayList<>();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
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
        //Name
        System.out.print(ENTER_NAME_QUERY);
        String name = scanner.nextLine();

        //Surname
        System.out.print(ENTER_SURNAME_QUERY);
        String surname = scanner.nextLine();

        //Number
        System.out.print(ENTER_NUMBER_QUERY);
        String number = scanner.nextLine();

        CONTACTS.add(new Contact(name, surname, number));
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

    private void editRecord() {

    }

    private void countRecords() {

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
                    if (possibleAction.equals(action.getAction())) {
                        return action;
                    }
                }
                System.out.println(INVALID_ACTION_QUERY);
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
    }
}
