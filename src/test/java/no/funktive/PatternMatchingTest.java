package no.funktive;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatternMatchingTest {

    record User(String name, int age) {
    }

    sealed interface PersistedUserOrError {
        // The permits clause has been omitted
        // as its permitted classes have been
        // defined in the same file.
    }

    record PersistedUser(int id, String name, int age) implements PersistedUserOrError {
    }

    record Error(String cause) implements PersistedUserOrError {
    }

    @Test
    void test() {
        var persistedUserOrError = persist(new User("Alex", 17));

        assertEquals(
                switch (persistedUserOrError) {
                    case PersistedUser persistedUser -> persistedUser.name();
                    case Error error -> error.cause();
                },
                persistedUserOrError instanceof PersistedUser qwe ? qwe.name() : ((Error) persistedUserOrError).cause()
        );

    }

    /**
     * {@snippet :
     * class HelloWorld {
     *     public static void main(String... args) { // @highlight substring = "args" @replace substring="public static " replacement=""
     *         System.out.println("Hello World!");  // @link substring="println" target="java.io.PrintStream#println(String)" @replace substring="System.out." replacement=""
     *     }
     * }
     *}
     */
    PersistedUserOrError persist(User user) {
        return switch (user) {
            case User(var name, var age) when age < 18 -> new Error("The user was under age");
            case User(String name, int age) -> new PersistedUser(1, name, age);
        };
    }

}
