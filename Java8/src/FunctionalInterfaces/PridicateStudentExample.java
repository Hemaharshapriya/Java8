package FunctionalInterfaces;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PridicateStudentExample {
    static Predicate<Student> p1 =(s) ->s.getGradeLevel()>=3;
    static Predicate<Student> p2 = (s) -> s.getGpa()>=4;
    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void filterStudentByGradeLevel(){
        System.out.println("Filter Students By Grade Level: \n");
//        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        });
    }
    public static void filterStudentsByGpa(){
        System.out.println("Filter students by GPA: \n");
//        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        });
    }
    public static void filterStudents(){
        System.out.println("Filter students : \n");
//        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.or(p2).negate().test(student)){
                System.out.println(student);
            }else{
                System.out.println(student);
            }
        });
    }
    public static void main(String[] args) {
        filterStudentByGradeLevel();
        filterStudentsByGpa();
        filterStudents();
    }
}
