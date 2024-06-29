import java.util.EnumSet;
import java.util.Scanner;

public class Main {

    // don't change the enum
    enum Alphabets {
        A, B, E, I, L, O, T, U 
    }

    EnumSet<Alphabets> enumSet;

    public static void main(String[] args) {
        Main object = new Main();

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().trim();

        // Change the code below this line
        switch (string) {
            case "setOfVowels":
                object.enumSet = EnumSet.of(Alphabets.A, Alphabets.E, Alphabets.I, Alphabets.O, Alphabets.U);
                break;
            case "setOfConsonants":
                object.enumSet = EnumSet.of(Alphabets.B, Alphabets.L, Alphabets.T);
                break;
            case "containsAOnly":
                object.enumSet = EnumSet.of(Alphabets.A);
                break;
            case "empty":
                object.enumSet = EnumSet.noneOf(Alphabets.class);
                break;
            case "exceptT-A-E":
                object.enumSet = EnumSet.complementOf(EnumSet.of(Alphabets.T, Alphabets.A, Alphabets.E));
                break;
            default : System.out.println("ERROR");
                break;
       }
        System.out.println(object.enumSet);
        // Change the code above this line
    }
}