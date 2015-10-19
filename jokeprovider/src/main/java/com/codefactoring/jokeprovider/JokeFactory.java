package com.codefactoring.jokeprovider;

import java.util.Random;

public class JokeFactory {

    private static String[] jokes = {
            "How does a computer tell you it needs more memory? It says 'byte me'",
            "What did Mr. Spock find in the toilet? The Captain's log!",
            "Why did the computer go to the doctor? Because it had a virus!"
    };

    public String tellAJoke() {
        return jokes[new Random().nextInt(jokes.length -1)];
    }
}
