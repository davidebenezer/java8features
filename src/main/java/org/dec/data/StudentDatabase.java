package org.dec.data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {
    public static List<Student> getAllStudents() {

        //grade 2
        Student student1 = new Student("Adam",
                2,
                3.6,
                "male",
                Arrays.asList("swimming" , "basketball", "volleyball"));

        Student student2 = new Student("Paul",
                2,
                3.1,
                "male",
                Arrays.asList("swimming" , "basketball", "soccer"));

        //grade 3
        Student student3 = new Student("Eddie",
                3,
                4.0,
                "female",
                Arrays.asList("handball" , "basketball", "volleyball"));

        Student student4 = new Student("Angela",
                3,
                2.6,
                "female",
                Arrays.asList("archery" , "basketball", "volleyball"));

        //grade 4
        Student student5 = new Student("Phil",
                4,
                3.9,
                "male",
                Arrays.asList("soccer" , "basketball", "volleyball"));

        Student student6 = new Student("Emma",
                4,
                4.9,
                "female",
                Arrays.asList("swimming" , "soccer", "volleyball"));

        Student student7 = new Student("Adam",
                4,
                3.8,
                "male",
                Arrays.asList("archery" , "basketball", "volleyball"));

        Student student8 = new Student("Adam",
                4,
                3,
                "male",
                Arrays.asList("table tennis" , "basketball", "volleyball"));

        return Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8);
    }
}
