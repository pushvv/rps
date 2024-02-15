package rs.xoraxax.model;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Objects;

import static java.lang.Math.abs;

@Slf4j
public class Rules implements Comparator<Choice> {
    @Override
    public int compare(Choice c1, Choice c2) {
        log.debug("{} : {}", c1, c2);
        Objects.requireNonNull(c1);
        Objects.requireNonNull(c2);

        if (abs(c1.ordinal() - c2.ordinal()) < 2) {
            return c1.compareTo(c2);
        } else {
            return c2.compareTo(c1);
        }
    }
}
