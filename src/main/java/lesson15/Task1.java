package lesson15;

/*
Задача 1:
Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
При решении использовать коллекции.
 */

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        LinkedHashSet<Integer> array = new LinkedHashSet();

        Scanner console = new Scanner(System.in);
        System.out.println("Введите набор чисел в виде одной строки с клавиатуры:");
        String str = console.nextLine();
        console.close();

        Scanner scan = new Scanner(str);
        scan.useDelimiter("[;,\\s]+");

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                array.add(scan.nextInt());
            } else {
                scan.next();
            }
        }
        scan.close();
        System.out.println(array);
    }
}
