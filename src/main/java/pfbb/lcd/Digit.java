package pfbb.lcd;

import java.util.Arrays;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * Represent a single digit in a LCD display.
 * Associates the digit standard representation (eg '7') to its LCD counterpart,
 * made up of three lines containing the LCD segments.
 *
 * @author Pierre Fouché
 */
public enum Digit {
    // Declaring the 10 digits as follows makes it easy to visually validate each digit representation.
    //@formatter:off (don't let the IDE play with indentation!)
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

    /**
     * Holds the 10 digits indexed by their character representation.
     */
    private static Map<Character, Digit> index;

    private final char symbol;
    private final String line1;
    private final String line2;
    private final String line3;

    Digit(char symbol, String content) {
        this.symbol = symbol;
        this.line1 = content.substring(0, 3);
        this.line2 = content.substring(3, 6);
        this.line3 = content.substring(6, 9);
    }

    static {
        // Build the index, in Java 8 idiomatic way.
        index = Arrays.stream(values()).collect(toMap(Digit::getSymbol, identity()));
    }

    public char getSymbol() {
        return symbol;
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

    /**
     * Returns the digit LCD representation as a single String.
     * Mostly used to test each digit representation.
     */
    public String getRepresentation() {
        String representation = String.join("\n", line1, line2, line3);
        return representation;
    }

    /**
     * Returns the {@link Digit} matching the given character, if any.
     */
    public static Digit findDigit(char symbol) {
        Digit digit = index.get(symbol);
        if (digit == null)
            throw new IllegalArgumentException("No such digit!");
        return digit;
    }
}
