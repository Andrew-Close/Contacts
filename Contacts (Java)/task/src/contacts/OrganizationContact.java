package contacts;

public class OrganizationContact extends Contact {
    private String organizationName;
    private String address;

    public OrganizationContact(String phoneNumber, String organizationName, String address) {
        super(phoneNumber, false);
        this.organizationName = organizationName;
        this.address = address;
    }

    @Override
    public void showInfo() {
        System.out.println("Organization name: " + getOrganizationName());
        System.out.println("Address: " + getAddress());
        printCommonInfo();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}