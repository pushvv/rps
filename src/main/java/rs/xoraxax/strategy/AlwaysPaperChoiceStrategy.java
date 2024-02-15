package rs.xoraxax.strategy;

import rs.xoraxax.model.Choice;

public class AlwaysPaperChoiceStrategy implements ChoiceStrategy {
    @Override
    public Choice makeChoice() {
        return Choice.PAPER;
    }
}
