package org.dec.MethodReference;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

    public static void main(String[] args) {
        //function Method reference
        Function<String, String> function = s -> s.toUpperCase();
        Function<String, String> function2 = String::toUpperCase;
        System.out.println(function.apply("Hello World"));
        System.out.println(function2.apply("Hello World"));

        //Consumer Example
        Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out::println;
        consumer.accept("Hello World Consumer");
        consumer2.accept("Hello World Consumer");

        Consumer<Student> consumer3 = Student::printActivities;
        StudentDatabase.getAllStudents().forEach(consumer3);

        //supplier
        Supplier<String> supplier = () -> "Hello World Supplier";



    }


}
