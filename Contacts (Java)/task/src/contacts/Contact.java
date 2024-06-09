package contacts;

import static contacts.AppMessages.INVALID_NUMBER;
import static contacts.ContactApp.checkPhoneNumber;

/**
 * A class which holds information about a contact.
 */
public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        setPhoneNumber(phoneNumber);
    }

    /**
     * Returns if this contact has a valid phone number.
     * @return whether the contact has a valid phone number
     */
    public boolean hasNumber() {
        return !"[no number]".equals(getPhoneNumber()) && !"".equals(getPhoneNumber());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println(INVALID_NUMBER);
            this.phoneNumber = "[no number]";
        }
    }
}
