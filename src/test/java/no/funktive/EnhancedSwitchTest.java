package no.funktive;


import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnhancedSwitchTest {

    int switchStatementApproach(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return 16;
            case SATURDAY:
            case SUNDAY:
                return 24;
            default:
                throw new IllegalArgumentException(dayOfWeek.name() + " was given, but not handled");
        }
    }

    int switchExpressionApproach(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 16;
            case SATURDAY, SUNDAY -> 24;
        };
    }

    @Test
    void test() {
        assertEquals(16, switchStatementApproach(DayOfWeek.WEDNESDAY));
        assertEquals(16, switchExpressionApproach(DayOfWeek.WEDNESDAY));
    }

}
