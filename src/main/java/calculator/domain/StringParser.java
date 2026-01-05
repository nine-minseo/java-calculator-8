package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(?<customDelimiter>.)\\\\n(?<numbers>.+)");

    public String[] parse(String input) {
        if (input == null || input.isBlank()) {
            //System.out.println("결과 : 0");
            return new String[]{"0"};
        }

        if (input.startsWith("//")) {
            return parseCustomDelimiter(input);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private String[] parseCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String customDelimiter = matcher.group("customDelimiter");
        String numbers = matcher.group("numbers");

        return numbers.split(Pattern.quote(customDelimiter) + "|,|:");
    }
}
