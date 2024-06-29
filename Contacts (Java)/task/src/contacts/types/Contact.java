package contacts.types;

import static contacts.AppMessages.INVALID_NUMBER;
import static contacts.PhoneNumberVerifier.checkPhoneNumber;

/**
 * A class which holds information about a contact.
 */
public abstract class Contact {
    private String phoneNumber;

    Contact() {}

    Contact(String phoneNumber) {
        setPhoneNumber(phoneNumber);
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
}
