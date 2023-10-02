package no.funktive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MindBlownTest {


    @Test
    void test() {
        int codePoint = 129327;
        assertEquals(true, Character.isEmoji(codePoint));
        System.out.println(Character.toChars(codePoint));
    }

}
