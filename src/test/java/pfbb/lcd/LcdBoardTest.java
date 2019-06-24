package pfbb.lcd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * ...
 *
 * @author Pierre Fouché
 */
class LcdBoardTest {

    @Test
    void getRepresentation_ok() {
        LcdBoard board = new LcdBoard();

        String rep = board.getRepresentation(42);
        //@formatter:off
        assertThat(rep).isEqualTo(
          "     _ \n" +
          "|_|  _|\n" +
          "  | |_ ");
        //@formatter:on
    }

    @Test
    void getRepresentation_visual() {
        LcdBoard board = new LcdBoard();

        String rep = board.getRepresentation(42);

        System.out.println("42: \n" + rep);
    }
}