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

import java.util.Iterator;
import java.util.List;

public class Student {

    private static final int MAX_COURSE = 4;
    private static final double MIN_RATING = 3.0;

    private String name;
    private String group;
    private int course;
    private List<Integer> assessments;

    public Student(String name, String group, int course, List<Integer> assessments) {
        this.name = name;
        this.group = group;
        this.course = Math.max(1, Math.min(course, MAX_COURSE));
        this.assessments = assessments;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getAssessments() {
        return assessments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageGrade() {
        if (assessments.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : assessments) {
            sum = sum + grade;
        }
        return sum / assessments.size();
    }

    public void promoteToNextCourse() {
        if (course < MAX_COURSE) {
            course++;
        }
    }

    public static void checkingStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double averageGrade = student.getAverageGrade();

            if (averageGrade < MIN_RATING) {
                iterator.remove();
                System.out.println("Отчислен: " + student.getName() + " средний балл " + averageGrade);
            } else {
                student.promoteToNextCourse();
                System.out.println("Переведен на курс " + student.getCourse() + ": " + student.getName());
            }
        }
    }
}
