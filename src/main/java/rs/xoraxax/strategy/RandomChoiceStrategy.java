package rs.xoraxax.strategy;

import rs.xoraxax.model.Choice;

import java.util.concurrent.ThreadLocalRandom;

public class RandomChoiceStrategy implements ChoiceStrategy {
    @Override
    public Choice makeChoice() {
        Choice[] values = Choice.values();
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }
}
