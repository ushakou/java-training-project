package lesson15.task3;

/*
Задача 3:
Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
Написать метод, который удаляет студентов со средним баллом <3. Если средний
балл>=3, студент переводится на следующий курс. Дополнительно написать метод
printStudents(List<Student> students, int course), который получает список студентов и
номер курса. А также печатает на консоль имена тех студентов из списка, которые
обучаются на данном курсе.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Student gena = new Student("Гена", "CL-39", 1, Arrays.asList(3, 3, 4, 4));
        Student petr = new Student("Петя", "CL-39", 2, Arrays.asList(5, 5, 1, 5));
        Student ivan = new Student("Ваня", "CL-39", 4, Arrays.asList(3, 3, 1, 2));

        students.add(gena);
        students.add(petr);
        students.add(ivan);

        Student.checkingStudents(students);

        printStudents(students, 1);
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("К сожалению этот курс пустой.");
        }
    }
}
