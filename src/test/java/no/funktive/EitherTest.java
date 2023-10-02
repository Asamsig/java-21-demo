package no.funktive;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EitherTest {


    sealed interface Either<L, R> {
        boolean isLeft();

        boolean isRight();
    }

    record Right<L, R>(R right) implements Either<L, R> {
        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }
    }

    record Left<L, R>(L left) implements Either<L, R> {
        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }
    }

    sealed interface Error {
        Exception cause();
    }

    record MyError(RuntimeException cause) implements Error {
    }
    record AnotherError(RuntimeException cause) implements Error {
    }

    @Test
    void right() {
        Assertions.assertEquals(
                "the value is HELLO, WORLD",
                handle(new Right<>("hello, world"))
        );
    }

    @Test
    void left() {
        Assertions.assertEquals(
                new MyError(new RuntimeException("Typed error channel exception")).toString(),
                handle(new Left<>(new MyError(new RuntimeException("Typed error channel exception"))))
        );
    }

    String handle(Either<Error, String> test) {
        return switch (test) {
            case Left<Error, String>(var left) -> switch (left) {
                case MyError error -> error.toString();
                case AnotherError error -> error.toString();
            };
            case Right<Error, String>(var right) -> "the value is " + right.toUpperCase();
        };
    }
}

