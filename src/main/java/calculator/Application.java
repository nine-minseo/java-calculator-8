package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int sum = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        if (inputString.isEmpty()) {
            sum = 0;
        } else {
            String[] inputStringArr = inputString.split("[,|:]");
            for (String string : inputStringArr) {
                sum += Integer.parseInt(string);
            }
        }
        System.out.println("결과 : " + sum);
    }
}
