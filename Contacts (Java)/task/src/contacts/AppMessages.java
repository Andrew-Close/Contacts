package contacts;

/**
 * A class which holds all messages to be displayed to the user in one spot for organization.
 */
public class AppMessages {
    /*
    Messages
    (general messages that state what is happening in the app)
     */
    public static String RECORD_ADDED = "The record added.";
    public static String RECORD_REMOVED = "The record removed!";
    public static String RECORD_UPDATED = "The record updated!";
    public static String COUNT_FORMAT = "The Phone Book has %d records.";

    /*
    Queries
    (messages that ask for user input)
     */
    public static String MAIN_MENU_QUERY = "Enter action (add, remove, edit, count, info, exit): ";
    public static String ENTER_NAME_QUERY = "Enter the name: ";
    public static String ENTER_SURNAME_QUERY = "Enter the surname: ";
    public static String ENTER_NUMBER_QUERY = "Enter the number: ";
    public static String ENTER_TYPE_QUERY = "Enter the type (person, organization): ";
    public static String ENTER_BIRTHDATE_QUERY = "Enter the birth date: ";
    public static String ENTER_GENDER_QUERY = "Enter the gender (M, F): ";
    public static String ENTER_ORGNAME_QUERY = "Enter the organization name: ";
    public static String ENTER_ADDRESS_QUERY = "Enter the address: ";
    public static String ENTER_INDEX_QUERY = "Enter index to show info: ";
    public static String SELECT_RECORD_QUERY = "Select a record: ";
    public static String SELECT_PERSON_FIELD_QUERY = "Select a field (name, surname, number): ";

    /*
    Errors
    (error messages for when something goes wrong or the state of the app disallows certain actions.
    queries that are also error messages are placed in this category)
     */
    public static String NO_RECORDS_TO_REMOVE = "No records to remove!";
    public static String NO_RECORDS_TO_EDIT = "No records to edit!";
    public static String NO_RECORDS_TO_LIST = "No records to list!";
    // For use with the getValidAction method
    public static String INVALID_ACTION_QUERY = "Please enter a valid action (add, remove, edit, count, list, exit): ";
    // For use with the getValidField method
    public static String INVALID_FIELD_QUERY = "Please enter a valid field (name, surname, number): ";
    // For use with the getValidType method
    public static String INVALID_TYPE_QUERY = "Please enter a valid type (person, organization): ";
    // For use with the getValidRecordSelection method
    public static String INVALID_RECORD_SELECTION_QUERY = "Please enter a valid number within the size of the contact list: ";
    // For use with the executeAction method as the default switch branch
    public static String INVALID_PASSED_ACTION = "The passed action was invalid. The user input may have been correct, but the value which was used was not.";
    // For use with the number setter in a contact object
    public static String INVALID_NUMBER = "Wrong number format!";
    // For use with the getAndVerifyBirthDate method
    public static String INVALID_BIRTHDATE = "Bad birth date!";
    // For use with the getAndVerifyGender method
    public static String INVALID_GENDER = "Bad gender!";
}
