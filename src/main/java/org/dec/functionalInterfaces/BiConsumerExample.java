package org.dec.functionalInterfaces;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name+ ": "+activities);
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
        studentList.forEach(student -> {});
    }

}
