package contacts;

import java.time.LocalDateTime;

import static contacts.AppMessages.INVALID_NUMBER;
import static contacts.ContactApp.PhoneNumberVerifier.checkPhoneNumber;


/**
 * A class which holds information about a contact.
 */
public abstract class Contact {
    protected String phoneNumber;
    protected final LocalDateTime timeCreated;
    protected LocalDateTime timeLastEdit;
    protected final boolean isPerson;

    protected Contact(String phoneNumber, boolean isPerson) {
        setPhoneNumber(phoneNumber);
        this.isPerson = isPerson;
        this.timeCreated = LocalDateTime.now();
        this.timeLastEdit = LocalDateTime.now();
    }

    public abstract void showInfo();

    protected void printCommonInfo() {
        System.out.println("Number: " + getPhoneNumber());
        System.out.println("Time created: " + this.timeCreated);
        System.out.println("Time last edit: " + this.timeLastEdit);
    }

    /**
     * Updates timeLastEdit to equal the current datetime.
     */
    public void updateLastEditTime() {
        this.timeLastEdit = LocalDateTime.now();
    }

    /**
     * Returns if this contact has a valid phone number.
     * @return whether the contact has a valid phone number
     */
    public boolean hasNumber() {
        return !"[no number]".equals(getPhoneNumber()) && !"".equals(getPhoneNumber());
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

    public boolean isPerson() {
        return isPerson;
    }
}
