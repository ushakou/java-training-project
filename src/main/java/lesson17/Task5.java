package lesson17;

import java.util.Scanner;
import java.util.function.Supplier;

/*
Задача 5:
Используя Supplier написать метод, который будет возвращать введенную с консоли
строку задом наперед.
 */

public class Task5 {

    public static void main(String[] args) {

        Supplier<String> reverse = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите строку:");
            String input = scanner.nextLine();
            scanner.close();

            return new StringBuilder(input).reverse().toString();
        };

        String result = reverse.get();
        System.out.println("Строка в реверсном виде: " + result);
    }
}
