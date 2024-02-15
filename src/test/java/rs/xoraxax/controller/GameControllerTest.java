package rs.xoraxax.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.xoraxax.model.Choice;
import rs.xoraxax.model.Player;
import rs.xoraxax.model.Rules;
import rs.xoraxax.view.RosterView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {
    public static final int NUMBER_OF_ROUNDS = 3;
    @Mock
    private Rules rules;

    @Mock
    private RosterView view;

    @Mock
    private Player playerA;

    @Mock
    private Player playerB;

    GameController controller;

    @BeforeEach
    void setup() {
        controller = new GameController(NUMBER_OF_ROUNDS, rules, view, playerA, playerB);
    }

    @Test
    void game_shouldRun() {
        when(playerA.makeChoice()).thenReturn(Choice.ROCK);
        when(playerA.getName()).thenReturn("A");
        when(playerB.makeChoice()).thenReturn(Choice.PAPER);
        when(playerB.getName()).thenReturn("B");
        when(rules.compare(Choice.ROCK, Choice.PAPER)).thenReturn(-1);

        controller.run();

        // Verify that the expected methods were called
        verify(playerA, times(NUMBER_OF_ROUNDS)).makeChoice();
        verify(playerB, times(NUMBER_OF_ROUNDS)).makeChoice();
        verify(rules, times(NUMBER_OF_ROUNDS)).compare(Choice.ROCK, Choice.PAPER);
        verify(view).display("A", "B", 0L, (long) NUMBER_OF_ROUNDS, 0L, (long) NUMBER_OF_ROUNDS);
    }
}