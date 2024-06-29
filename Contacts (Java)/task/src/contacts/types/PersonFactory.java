package contacts.types;

public class PersonFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        return new Person();
    }
}
