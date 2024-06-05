import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String regex = "(?i)password[\\s:]*\\w+";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        list = list.stream()
                .map(x -> x.replaceAll("(?i)^password[\\s:]*", ""))
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            System.out.println("No passwords found.");
        } else {
            list.forEach(System.out::println);
        }
    }
}