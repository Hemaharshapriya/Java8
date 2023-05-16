package streams;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {
    public static void main(String[] args) {
        //Student name and there activities in map streams are used for easy maniuations with collections
        Predicate<Student> studentPredicate = (student)->student.getGpa()>=3.9;
        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream()
                .filter(student->student.getGradeLevel()>=3)// retrun stream of students
                .filter(studentPredicate)// stream of students
                .collect(Collectors.toMap(Student::getName,Student::getActivities));// stremes are lazy no intermidiate operaion without terminal operation
        System.out.println(studentMap);
    }
}
