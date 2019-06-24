package pfbb.lcd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static pfbb.lcd.Digit.ZERO;

class DigitTest {

    @Test
    void getRepresentation_ok() {

        String actual = ZERO.getRepresentation();

        //@formatter:off
        assertThat(actual).isEqualTo(
                " _ \n" +
                "| |\n" +
                "|_|");
        //@formatter:on
    }

    @Test
    void getRepresentation_visual() {

        String actual = ZERO.getRepresentation();

        System.out.println("Zero: \n" + actual);
    }

    /**
     * Tests that all digits are correctly indexed.
     */
    @ParameterizedTest
    @ValueSource(chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
    void findDigit_ok(char symbol) {

        Digit digit = Digit.findDigit(symbol);

        assertThat(digit.getSymbol()).isEqualTo(symbol);
    }
}