package org.dec.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    static Comparator<Integer> comp = (a,b) -> a.compareTo(b);
    public static void main(String[] args) {
        UnaryOperator<String> unaryOperator = String::toUpperCase;
        System.out.println(unaryOperator.apply("Hello World"));

        BinaryOperator<Integer> binaryOperator = (a,b) -> a * b;
        System.out.println(binaryOperator.apply(2, 3));

        BinaryOperator<Integer> maxby = BinaryOperator.maxBy(comp);
        System.out.println(maxby.apply(2,3));
        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comp);
        System.out.println(minBy.apply(2,3));
    }
}
