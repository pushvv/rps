package rs.xoraxax.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Integer.signum;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class RulesTest {
    Rules rules = new Rules();

    @ParameterizedTest
    @MethodSource("rps")
    void testCompare(Choice c1, Choice c2, int expected) {
        int actual = signum(rules.compare(c1, c2));
        assertThat(expected).isEqualTo(signum(actual));
    }

    private static Collection<Object[]> rps() {
        return Arrays.asList(
                new Object[]{Choice.ROCK, Choice.ROCK, 0},
                new Object[]{Choice.ROCK, Choice.PAPER, -1},
                new Object[]{Choice.ROCK, Choice.SCISSORS, 1},
                new Object[]{Choice.PAPER, Choice.ROCK, 1},
                new Object[]{Choice.PAPER, Choice.PAPER, 0},
                new Object[]{Choice.PAPER, Choice.SCISSORS, -1},
                new Object[]{Choice.SCISSORS, Choice.ROCK, -1},
                new Object[]{Choice.SCISSORS, Choice.PAPER, 1},
                new Object[]{Choice.SCISSORS, Choice.SCISSORS, 0}
        );
    }
}