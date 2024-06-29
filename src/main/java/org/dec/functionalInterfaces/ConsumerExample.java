package org.dec.functionalInterfaces;

import org.dec.data.Student;
import org.dec.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static List<Student> students = StudentDatabase.getAllStudents();

    static Consumer<Student> c2 = s -> System.out.println(s);
    static Consumer<Student> c3 = s -> System.out.print(s.getName());
    static Consumer<Student> c4 = s -> System.out.println(s.getActivities());
    public static void getStudents(){

        Consumer<Student> studentConsumer = student -> {System.out.println(student);};
        students.forEach(studentConsumer);

        //Print all Students
        students.forEach(a -> System.out.println(a));
        students.forEach(System.out::println);
    }

    public static void printNameAndActivities(){
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(c3.andThen(c4));
//        students.forEach(((Consumer<Student>) s -> System.out.print(s.getName()))
//                .andThen(s -> System.out.println(s.getActivities())));
        students.forEach(student -> System.out.println(student.getName()));
    }

    public static void filterGradeAndPrint(){
        students.forEach((s)->{
            if(s.getGradeLevel()==2){
                c3.andThen(c4).accept(s);
            }
        });
    }

    public static void filterGradeAndCGPAAndPrint(){
        students.forEach((s)->{
            if(s.getGradeLevel()==4 && s.getGpa() > 4){
                c3.andThen(c4).accept(s);
            }
        });
    }

    public static void main(String[] args) {
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("Hello World");
//        getStudents();
//        printNameAndActivities();
//        filterGradeAndPrint();
        filterGradeAndCGPAAndPrint();
    }
}
