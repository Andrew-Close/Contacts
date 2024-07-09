package contacts;

public class PersonContact extends Contact {
    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public PersonContact(String phoneNumber, String name, String surname, String birthDate, String gender) {
        super(phoneNumber, true);
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Birth date: " + getBirthDate());
        System.out.println("Gender: " + getGender());
        printCommonInfo();
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}