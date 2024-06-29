package org.dec.imperativeVsDeclarative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicate {

    static List<Integer> intList = Arrays.asList(1,2,3,2,4,5,4,4,6,3,7,8,9,1,2,2);

    public static void main(String[] args){
        imperative();
        declarative();
    }

    public static void imperative(){
        List<Integer> noDuplicate = new ArrayList<>();
        for(Integer i : intList){
            if(!noDuplicate.contains(i)){
                noDuplicate.add(i);
            }
        }
        System.out.println("Imperative remove Duplicates: " + noDuplicate);
    }

    public static void declarative(){
        System.out.println("Declarative remove Duplicates: " + intList.stream().distinct().toList());
    }
}
