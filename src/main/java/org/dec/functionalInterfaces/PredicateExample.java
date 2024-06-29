package org.dec.functionalInterfaces;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    static Predicate<Integer> predicate = x -> x%2==0;
    static Predicate<Integer> predicate2 = x -> x%3==0;
    public static final Predicate<Student> studPred1 = s -> s.getGpa() >= 4;
    public static final Predicate<Student> studPred2 = s -> s.getGradeLevel() > 3;
    static List<Student> studentList = StudentDatabase.getAllStudents();
    static BiConsumer<String, List<String>> studBiConsumer =
            (name,activities) -> {System.out.println("Name: "+name+ " , Activities: "+activities);} ;

    static BiPredicate<Integer, Double> studBiPredicate = (grade, gpa) -> gpa >=4 || grade > 3;

    public static void main(String[] args) {
        int x=10;
        System.out.println(x + " divisible by 2:" + predicate.test(x));
        System.out.println(x + " (x does not get replaced since its printed before processing, divisible by 2 and 5" + predicate.and(predicate2).test(x=6));
        System.out.println(x);
        x=8;
        System.out.println(x + " divisible by 2 or 3:" + predicate.or(predicate2).test(x));
        System.out.println(x + " divisible by 2 or 3 negate:" + predicate.or(predicate2).negate().test(x));
        getStudentsWithFilters();

    }

    public static void getStudentsWithFilters(){

        studentList.forEach(s -> {
            if(studPred1.test(s)){
                System.out.println("Students with gpa greater than or equal to 4: "+s);
            }
        });

        // get students above 3rd grade with gpa >4
        studentList.forEach(s->{
            if(studPred1.and(studPred2).test(s)){
                System.out.println("Students with gpa greater than or equal to 4 and grade greater than 3: "+s);
            }
        });

        System.out.println("Predicate and Bi Consumer or condition" );
        // get students above 3rd and gpa > 4 with biconsumer
        studentList.forEach(s->{
            if(studPred1.or(studPred2).test(s)){
                studBiConsumer.accept(s.getName(), s.getActivities());
            }
        });

        System.out.println("BiPredicate with Bi Consumer");
        // biconsumer with bi predicate
        studentList.forEach(s -> {
            if(studBiPredicate.test(s.getGradeLevel(), s.getGpa())){
                studBiConsumer.accept(s.getName(), s.getActivities());
            }
        });
    }
}
