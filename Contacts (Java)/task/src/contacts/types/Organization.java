package contacts.types;

public class Organization extends Contact {
    private String organizationName;
    private String address;

    Organization() {}

    Organization(String organizationName, String phoneNumber, String address) {
        super(phoneNumber);
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
