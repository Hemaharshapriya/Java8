package FunctionalInterfaces;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c3 = (student)-> System.out.println(student.getName());
    static Consumer<Student> c4 = (student)-> System.out.println(student.getActivities());
    static List<Student> studentList = StudentDatabase.getAllStudents();

    public static void printName(){
        System.out.println("Printing the student details \n");
        Consumer<Student> c2 = System.out::println;// replaced lambda with method reference
        studentList.forEach(c2);
    }
    public static void printNameAndAttribute(){
        System.out.println("printing according to student name and attribute");
        studentList.forEach(c3.andThen(c4));// this is called consumer chaining

    }
    public static void printNameAndAttributeUsingCondition(){
        System.out.println("******************************* \n print Name And Attribute Using Condition");
        studentList.forEach(student -> {
            if(student.getGradeLevel()>=3 && student.getGender()=="female"){
                c3.andThen(c4).accept(student);
            }
        });// this is called consumer chaining

    }
    public static void main(String[] args) {
        Consumer<String> c1= (s)-> System.out.println(s.toUpperCase());
        c1.accept("Java-8");
        printName();
        printNameAndAttribute();
        printNameAndAttributeUsingCondition();
    }
}
