package baseball;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

public enum Messages{

    ASK("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INIT("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : ", System.out::print);

    private final String message;
    private final Consumer<String> printer;

    Messages(String message) {
        this.message = message;
        this.printer = System.out::println;
    }
    Messages(String message, Consumer<String> printer) {
        this.message = message;
        this.printer = printer;
    }

    public void printMessage() {
        this.printer.accept(this.message);
    }

    public static void printScore(List<Integer> turnResult) {
        int strikes = turnResult.get(0);
        int balls = turnResult.get(1);

        StringJoiner baseString = new StringJoiner(" ");
        if (balls != 0) {
            baseString.add(String.format("%d볼", balls));
        }
        if (strikes != 0) {
            baseString.add(String.format("%d스트라이크", strikes));
        }
        if (baseString.length() == 0) {
            baseString.add("낫싱");
        }
        System.out.println(baseString);
    }
}
