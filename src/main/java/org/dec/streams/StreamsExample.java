package org.dec.streams;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;
import org.dec.functionalInterfaces.PredicateExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        // student name and activities in a map
        List<Student> studentList = StudentDatabase.getAllStudents();
        // merging activities when encountering duplicate keys.
        Map<String, List<String>> studMap = studentList.stream().
                collect(Collectors.toMap(Student::getName, Student::getActivities, (existingActivities, newActivities) -> {
                    List<String> mergedActivities = new ArrayList<>(existingActivities);
                    mergedActivities.addAll(newActivities);
                    return mergedActivities;
                }));
        System.out.println(studMap);

        //ignoring duplicate keys and retaining the first value
        Map<String, List<String>> studMap2 = studentList.stream().collect(Collectors.toMap(student -> student.getName(),
                student -> student.getActivities(),
                (existing, newActivies)-> existing));
        System.out.println(studMap2);

        //Filter the students and peek the results of each step

        System.out.println("******************************************** peek the intermediate results**************************");
        System.out.println(studentList);
        Map<String, List<String>> studMap3 = studentList.stream().
                //peek(student -> System.out.println("Before filter: "+student)).
                filter(PredicateExample.studPred1).
                peek(student -> System.out.println("perform studPred1 filter: "+student)).
                filter(PredicateExample.studPred2).
                peek(student -> System.out.println("perform studPred2 filter: "+student)).
                collect(Collectors.toMap(student -> student.getName(),
                student -> student.getActivities(),
                (existing, newActivies)-> existing));
        System.out.println(studMap3);
        System.out.println("******************************************** end peek results**************************");

        //combining filters with OR
        Map<String, List<String>> studMap4 = studentList.stream().
                filter(PredicateExample.studPred2.or(PredicateExample.studPred1)).
                collect(Collectors.toMap(student -> student.getName(),
                        student -> student.getActivities(),
                        (existing, newActivies)-> existing));
        System.out.println(studMap4);

    }
}
