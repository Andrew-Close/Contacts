package contacts;

/**
 * A class which holds all messages to be displayed to the user in one spot for organization.
 */
public class AppMessages {
    /*
    Main menu
     */
    public static String MAIN_MENU_QUERY = "Enter action (add, remove, edit, count, list, exit): ";

    /*
    General messages
     */
    public static String ENTER_NAME_QUERY = "Enter the name: ";
    public static String ENTER_SURNAME_QUERY = "Enter the surname: ";
    public static String ENTER_NUMBER_QUERY = "Enter the number: ";
    public static String SELECT_RECORD_QUERY = "Select a record: ";

    /*
    Add record
     */
    public static String RECORD_ADDED = "The record added.";

    /*
    Remove record
     */
    public static String RECORD_REMOVED = "The record removed!";
    public static String NO_RECORDS_TO_REMOVE = "No records to remove!";

    /*
    List records
     */
    public static String NO_RECORDS_TO_LIST = "No records to list!";

    /*
    Error messages
     */
    // For use with the getValidAction method
    public static String INVALID_ACTION_QUERY = "Please enter a valid action (add, remove, edit, count, list, exit): ";
    // For use with the getValidRecordSelection method
    public static String INVALID_RECORD_SELECTION_QUERY = "Please enter a valid number within the size of the contact list: ";
    // For use with the executeAction method as the default switch branch
    public static String INVALID_PASSED_ACTION = "The passed action was invalid. The user input may have been correct, but the value which was used was not.";
}
