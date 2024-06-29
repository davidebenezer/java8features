package org.dec.lambdas;

import java.util.Comparator;

public class LambdaComparator {
    public static void main(String[] args) {
        // Prior to Lamdas

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Comparator using anonymous inner class: " +comparator.compare(1, 2));

        // With Lambdas
        Comparator<Integer> comparator2 = (a,b) -> a.compareTo(b);
        System.out.println("Comparator using lambdas: " +comparator2.compare(1, 2));
        Comparator<Integer> comparator3 = Integer::compareTo;
        System.out.println("Comparator using method reference: " +comparator2.compare(1, 2));
    }
}
