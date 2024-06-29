package contacts.types;

public class OrganizationFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        return new Organization();
    }
}
