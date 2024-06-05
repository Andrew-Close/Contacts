// You can experiment here, it won’t be checked

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {
  public static void main(String[] args) {
    // put your code here
    String text = "(abc123   )()";
    String regex = "^\\([^).]*\\)$";
    Matcher matcher = Pattern.compile(regex).matcher(text);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }
  }
}
