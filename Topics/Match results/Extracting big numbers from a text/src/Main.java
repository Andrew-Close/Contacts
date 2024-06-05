import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();

        // write your code here
        String regex = "\\d{10,}";
        Matcher matcher = Pattern.compile(regex).matcher(stringWithNumbers);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        for (String number : list) {
            String output = number + ":" + number.length();
            System.out.println(output);
        }
    }
}