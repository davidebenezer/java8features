package org.dec.MethodReference;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.function.Supplier;

public class RefactorMethodReferenceExample {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> StudentDatabase.getAllStudents().get(0);
        System.out.println(supplier.get());

        Supplier<Student> supplier2 = RefactorMethodReferenceExample::getStudent;
        System.out.println(supplier2.get());

    }
    public static Student getStudent(){
        return StudentDatabase.getAllStudents().get(0);
    }
}
