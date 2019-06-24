package pfbb.lcd;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Displays a positive integer given as input in an old-fashioned LCD style.
 *
 * @author Pierre Fouché
 */
public class LcdBoard {

    /**
     * The entry point.
     *
     * @param args a single positive integer
     */
    public static void main(String[] args) {
        // Perform args validation first.
        if (args.length == 0) {
            // Yes, using System.out...
            // We would use a genuine logger in a production system of course.
            System.out.println("Please enter a positive integer.");
            return;
        }
        Long number; // Use a Long to support a large number of digits.
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
        // Ok. We got a positive integer.
        // We can proceed
        LcdBoard board = new LcdBoard();
        String representation = board.getRepresentation(number);
        System.out.println(number + ":\n" + representation);
    }

    /**
     * Returns the LCD representation of the given number in a single String.
     * The returned String contains three lines containing the LCD segments.
     */
    String getRepresentation(long number) {
        // Turn the input number into a list of Digits.
        List<Digit> digits = toCharacterStream(number)
                .map(Digit::findDigit)
                .collect(toList());
        // Build the three LCD lines.
        String line1 = digits.stream().map(Digit::getLine1).collect(joining(" "));
        String line2 = digits.stream().map(Digit::getLine2).collect(joining(" "));
        String line3 = digits.stream().map(Digit::getLine3).collect(joining(" "));
        // Assemble the three lines together.
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
}
