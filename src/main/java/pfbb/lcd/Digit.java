package pfbb.lcd;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ...
 *
 * @author Pierre Fouché
 */
public enum Digit {
    //@formatter:off
    ZERO('0',
          " _ " +
          "| |" +
          "|_|"),

    ONE('1',
          "   " +
          "  |" +
          "  |"),

    TWO('2',
          " _ " +
          " _|" +
          "|_ "),

    THREE('3',
          " _ " +
          " _|" +
          " _|"),

    FOUR('4',
          "   " +
          "|_|" +
          "  |"),

    FIVE('5',
          " _ " +
          "|_ " +
          " _|"),

    SIX('6',
          " _ " +
          "|_ " +
          "|_|"),

    SEVEN('7',
          " _ " +
          "  |" +
          "  |"),

    EIGHT('8',
          " _ " +
          "|_|" +
          "|_|"),

    NINE('9',
          " _ " +
          "|_|" +
          "  |"),
    ;
    //@formatter:on
    private static Map<Character, Digit> index;

    private final char symbol;
    private final String line1;
    private final String line2;
    private final String line3;

    Digit(char symbol, String content) {
        this.symbol = symbol;
        this.line1 = content.substring(0,3);
        this.line2 = content.substring(3,6);
        this.line3 = content.substring(6,9);
    }

    static {
        index = Arrays.stream(values()).collect(Collectors.toMap(Digit::getSymbol, Function.identity()));
    }

    public char getSymbol() {
        return symbol;
    }

    public String getRepresentation() {
        String representation = String.join("\n", line1, line2, line3);
        return representation;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine3() {
        return line3;
    }

    public static Digit findDigit(char symbol) {
        Digit digit = index.get(symbol);
        if (digit == null)
            throw new IllegalArgumentException("No such digit!");
        return digit;
    }
}
