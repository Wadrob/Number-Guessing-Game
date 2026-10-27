package cli;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberGuessingGameCLITest {

    private NumberGuessingGameCLI game;

    @BeforeEach
    void setUp() {
        game = new NumberGuessingGameCLI();
    }

    @Test
    void shouldAcceptMinimumGuess() {
        assertEquals(1, game.checkGuess(1));
    }

    @Test
    void shouldAcceptMaximumGuess() {
        assertEquals(100, game.checkGuess(100));
    }

    @Test
    void shouldRejectGuessBelowMinimum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> game.checkGuess(0)
        );
    }

    @Test
    void shouldRejectGuessAboveMaximum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> game.checkGuess(101)
        );
    }

    @Test
    void shouldAcceptValidChoices() {
        assertEquals(1, game.checkChoice(1));
        assertEquals(2, game.checkChoice(2));
        assertEquals(3, game.checkChoice(3));
    }

    @Test
    void shouldRejectChoiceBelowMinimum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> game.checkChoice(0)
        );
    }

    @Test
    void shouldRejectChoiceAboveMaximum() {
        assertThrows(
                IllegalArgumentException.class,
                () -> game.checkChoice(4)
        );
    }

}