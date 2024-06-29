package org.dec.lambdas;

import java.util.function.Consumer;

public class LamdaVariable {
    static int b;

    public static void main(String[] args) {
        int i = 0;
        b++;
        //modifying local variable used inside lambda is restricted. instance variable modification is allowed
        //i++;
        Consumer<String> consumer = s -> System.out.println(i);
        Consumer<String> consumer2 = s->System.out.println(b);

        consumer.accept("1");
        consumer2.accept("41");
    }
}
