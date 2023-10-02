package no.funktive.exhaustiveness;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExhaustivenessPatternMatchingTest {


    @Test
    void test() {
        String actual = nonExhaustive(new NonExhaustiveImpl());

        assertEquals(
                "test",
                actual
        );

    }

    String nonExhaustive(NonExhaustive nonExhaustive) {
        return switch (nonExhaustive) {
            case NonExhaustiveImpl asd -> "test";
            default -> throw new IllegalStateException("Unexpected value: " + nonExhaustive);
        };
    }
}
