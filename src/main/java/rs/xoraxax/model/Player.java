package rs.xoraxax.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import rs.xoraxax.strategy.ChoiceStrategy;

@RequiredArgsConstructor
public class Player {
    @Getter
    private final String name;
    private final ChoiceStrategy strategy;

    public Choice makeChoice() {
        return strategy.makeChoice();
    }
}
