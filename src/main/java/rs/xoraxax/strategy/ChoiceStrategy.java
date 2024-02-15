package rs.xoraxax.strategy;

import rs.xoraxax.model.Choice;

@FunctionalInterface
public interface ChoiceStrategy {
    Choice makeChoice();
}
