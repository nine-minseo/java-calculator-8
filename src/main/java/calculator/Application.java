package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        int sum = 0;
        Pattern pattern = Pattern.compile("//(.)\\\\n(.+)");
        Matcher matcher = pattern.matcher(inputString);

        if (inputString.isEmpty()) {
            sum = 0;
        } else {
            if (matcher.matches()) {
                String customDelimiter = matcher.group(1);
                String stringToCheck = matcher.group(2);

                String delimiter = Pattern.quote(customDelimiter) + "|,|:";
                String[] digitArr = stringToCheck.split(delimiter);
                for (String digit : digitArr) {
                    sum += Integer.parseInt(digit);
                }
            } else {
                String[] digitArr = inputString.split("[,|:]");
                for (String digit : digitArr) {
                    sum += Integer.parseInt(digit);
                }
            }
        }
        System.out.println("결과 : " + sum);
    }
}
