package no.funktive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultilineStringTest {

    @Test
    void test() {
        var sql = """
                                  
                INSERT INTO users (name, age)
                  VALUES (?, ?)
                  WHERE age > 18
                  
                """.strip();

        // Currently in preview
//        var test = STR."""
//            Hello \{ sql } from multi-line template expression.
//        """;

        assertEquals("INSERT INTO users (name, age)\n  VALUES (?, ?)\n  WHERE age > 18", sql);
    }
}
