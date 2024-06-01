package contacts;

import java.util.Scanner;

public class ContactApp implements Runnable {
    Contact contact;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        System.out.println();

        contact = new Contact(name, surname, phoneNumber);
        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");
    }
}
