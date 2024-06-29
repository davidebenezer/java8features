package org.dec.streams;

import org.dec.data.StudentDatabase;

import java.util.Set;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        Set<String> students = StudentDatabase.getAllStudents().stream().map(
                student -> student.getName()
        ).collect(Collectors.toSet());

        System.out.println(students);
    }
}
