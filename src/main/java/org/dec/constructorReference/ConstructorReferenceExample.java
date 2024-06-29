package org.dec.constructorReference;

import org.dec.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get());

        Function<String, Student> function = Student::new;
        System.out.println(function.apply("John"));

    }
}
