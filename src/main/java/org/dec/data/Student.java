package org.dec.data;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int gradeLevel;
    private double gpa;
    private String gender;
    private List<String> activities = new ArrayList<>();

    public Student(String s) {
        this.name = s;
    }

    public void printActivities() {
        System.out.println(activities);
    }
}
