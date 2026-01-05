package calculator.controller;

import calculator.domain.Adder;
import calculator.domain.StringParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final StringParser parser = new StringParser();
    private final Adder adder = new Adder();

    public void run() {
        String input = InputView.readInput();

        String[] digitArr = parser.parse(input);

        OutputView.printResult(adder.sum(digitArr));
    }
}
