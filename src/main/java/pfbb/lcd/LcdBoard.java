package pfbb.lcd;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * ...
 *
 * @author Pierre Fouché
 */
public class LcdBoard {

    public String getRepresentation(long number) {
        List<Digit> digits = toCharacterStream(number)
                .map(Digit::findDigit)
                .collect(toList());
        String line1 = digits.stream().map(Digit::getLine1).collect(joining(" "));
        String line2 = digits.stream().map(Digit::getLine2).collect(joining(" "));
        String line3 = digits.stream().map(Digit::getLine3).collect(joining(" "));
        String s = String.join("\n", line1, line2, line3);
        return s;
    }

    /**
     * Wraps the complexity of turning a number into a stream of characters.
     */
    private Stream<Character> toCharacterStream(long number) {
        return Long.toString(number)
                .chars()
                .mapToObj(i -> (char) i);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        Long number;
        try {
            number = Long.valueOf(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        if (number < 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }
        LcdBoard board = new LcdBoard();
        String representation = board.getRepresentation(number);
        System.out.println(number + ":\n" + representation);
    }
}
