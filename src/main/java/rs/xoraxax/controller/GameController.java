package rs.xoraxax.controller;

import lombok.RequiredArgsConstructor;
import rs.xoraxax.model.Player;
import rs.xoraxax.model.Rules;
import rs.xoraxax.view.RosterView;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@RequiredArgsConstructor
public class GameController {
    private final long numberOfRounds;
    private final Rules rules;
    private final RosterView view;
    private final Player playerA;
    private final Player playerB;

    public void run() {
        Map<Integer, Long> roster = Stream
                .generate(() -> rules.compare(playerA.makeChoice(), playerB.makeChoice()))
                .limit(numberOfRounds)
                .collect(groupingBy(i -> (int) Math.signum(i), counting()));
        Long pA = roster.getOrDefault(1, 0L);
        Long pB = roster.getOrDefault(-1, 0L);
        Long tie = roster.getOrDefault(0, 0L);
        view.display(playerA.getName(), playerB.getName(), pA, pB, tie, numberOfRounds);
    }
}