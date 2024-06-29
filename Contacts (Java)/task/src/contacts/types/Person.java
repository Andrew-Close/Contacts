package contacts.types;

import java.time.LocalDate;

public class Person extends Contact {
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthDate;

    Person() {}

    Person(String name, String surname, String gender, String phoneNumber, LocalDate birthDate) {
        super(phoneNumber);
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
