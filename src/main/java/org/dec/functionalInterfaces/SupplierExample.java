package org.dec.functionalInterfaces;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> StudentDatabase.getAllStudents().get(0);
        System.out.println(supplier.get());

        Supplier<List<Student>> supplier2 = StudentDatabase::getAllStudents;
        System.out.println(supplier2.get());
    }
}
