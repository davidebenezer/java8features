package org.dec.functionalInterfaces;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> stringFunction = String::toUpperCase;
        Function<String, String> addDefault = s -> s.toUpperCase()+"default";

        System.out.println(stringFunction.apply("Hello"));
        System.out.println(stringFunction.andThen(addDefault).apply("Hello"));
        System.out.println(stringFunction.compose(addDefault).apply("Hello"));

        Function<List<Student>, Map<String, Double>> studFunction = (students) -> {
            Map<String,Double> map = new HashMap<>();
            students.forEach(s->{
                if(PredicateExample.studPred1.test(s)) {
                    map.put(s.getName(), s.getGpa());
                }
            });
            return map;
        };

        System.out.println(studFunction.apply(StudentDatabase.getAllStudents()));
        // biFunction
        System.out.println("Bi Function");
        BiFunction<List<Student>, Predicate, Map<String, Double>> biFunction = (studentList, predicate) -> {
            Map<String, Double> map = new HashMap<>();
            studentList.forEach(s->{
                if(predicate.test(s)) {
                    map.put(s.getName(), s.getGpa());
                }
            });
            return map;
        };

        System.out.println(biFunction.apply(StudentDatabase.getAllStudents(), PredicateExample.studPred1));
    }
}
