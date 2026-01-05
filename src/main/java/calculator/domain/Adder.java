package calculator.domain;

public class Adder {
    public int sum(String[] digitArr) {
        int sum = 0;
        for (String digit : digitArr) {
            sum += parseToInt(digit);
        }

        return sum;
    }

    private int parseToInt(String input) {
        try {
            int num = Integer.parseInt(input.trim());
            validatePositive(num);

            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구분자 외의 문자가 포함되어 있습니다: " + input);
        }
    }

    private void validatePositive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }
}
