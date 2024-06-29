package contacts;

import contacts.types.*;

public class Main {
    public static void main(String[] args) {
        /*
        ContactApp app = new ContactApp();
        app.run();
         */
        ContactFactory contactFactory;
        ContactBuilder contactBuilder;
        Contact contact;

        contactFactory = new OrganizationFactory();
        contactBuilder = contactFactory.createContact();
    }
}
