package org.dec.imperativeVsDeclarative;

import java.util.stream.IntStream;

public class SumOfNumbers {
    public static void main(String[] args){
        imperative();
        declarative();
    }

    public static void imperative(){
        int total = 0;
        for(int i = 1; i <= 100; i++){
            total+=i;
        }
        System.out.println("Sum using imperative: " + total);
    }

    public static void declarative(){
        System.out.println("Sum using declarative: " + IntStream.rangeClosed(1,100).parallel().sum());
    }
}
