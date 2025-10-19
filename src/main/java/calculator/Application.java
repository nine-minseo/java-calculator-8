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
            System.out.println("결과 : 0");
            return;
        }

        String[] digitArr;
        String digitAndDelimiter;
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String quotedCustomDelimiter = Pattern.quote(customDelimiter);
            String delimiter = quotedCustomDelimiter + "|,|:";
            digitAndDelimiter = "^([0-9]+|,|(" + quotedCustomDelimiter + "))$";

            String stringToCheck = matcher.group(2);
            digitArr = stringToCheck.split(delimiter);
        } else {
            digitAndDelimiter = "^([0-9]+|,|:)$";
            digitArr = inputString.split("[,:]");
        }

        Pattern numOrDelimiterPattern = Pattern.compile(digitAndDelimiter);

        for (String digit : digitArr) {
            if (!numOrDelimiterPattern.matcher(digit).matches()) {
                throw new IllegalArgumentException();
            }
        }
        for (String digit : digitArr) {
            int num = Integer.parseInt(digit);
            if (num < 0) {
                throw new IllegalArgumentException();
            }
            sum += num;
        }
        System.out.println("결과 : " + sum);
    }
}
