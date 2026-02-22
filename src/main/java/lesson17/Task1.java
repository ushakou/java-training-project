package lesson17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/*
Задача 1:
Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
когда пользователю исполнится 100 лет. Использовать Date/Time API.
 */

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату своего рождения в формате: dd:MM:yyyy");
        String date = scanner.nextLine();
        scanner.close();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");

        try {

            LocalDate birthday = LocalDate.parse(date, formatter);
            System.out.println("Ваша дата рождения: " + birthday.format(formatter));

            LocalDate oneHundredYears = birthday.plusYears(100);
            System.out.println("Вам будет 100 лет: " + oneHundredYears.format(formatter));

        } catch (DateTimeParseException e) {
            System.out.println("Вы ввели ДР не в правильном формате.");
        }
    }
}
