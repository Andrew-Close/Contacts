// You can experiment here, it won’t be checked

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
  public static void main(String[] args) {
    PersonFactory factory = new PersonFactory();
    PersonContact contact = (PersonContact) factory.createContact("andrew", 16);
    contact.speak();
    contact.unfriend();
  }
}

interface Factory {
  public Contact createContact();
}

class PersonFactory implements Factory {
  @Override
  public Contact createContact() {
    return new PersonContact();
  }

  public Contact createContact(String name, int age) {
    return new PersonContact(name, age);
  }
}

abstract class Contact {
  protected String name;

  public void speak() {
    System.out.println("My name is " + this.name);
  }

  public void contactNumber() {
    System.out.println("This is contact #1");
  }
}

class PersonContact extends Contact {
  private int age;

  public PersonContact() {
    this.name = "undefined";
    this.age = -1;
  }

  public PersonContact(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public void speak() {
    System.out.println("My name is " + this.name + " and I am " + this.age + " years old.");
  }

  public void unfriend() {
    System.out.println("This contact has been unfriended");
  }
}