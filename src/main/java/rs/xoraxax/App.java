package rs.xoraxax;

import rs.xoraxax.controller.GameController;
import rs.xoraxax.model.Player;
import rs.xoraxax.model.Rules;
import rs.xoraxax.strategy.AlwaysPaperChoiceStrategy;
import rs.xoraxax.strategy.RandomChoiceStrategy;
import rs.xoraxax.view.ConsoleRosterView;
import rs.xoraxax.view.RosterView;

public class App {
    public static void main(String[] args) {
        Rules rules = new Rules();
        RosterView view = new ConsoleRosterView();
        Player playerA = new Player("Player A",
                new AlwaysPaperChoiceStrategy());
        Player playerB = new Player("Player B",
                new RandomChoiceStrategy());

        new GameController(100, rules, view, playerA, playerB)
                .run();
    }
}
