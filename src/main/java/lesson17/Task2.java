package lesson17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
Задача 2:
Используя Predicate среди массива чисел вывести только те, которые являются
положительными.
 */

public class Task2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>() {{
            add(5);
            add(-9);
            add(8);
            add(0);
        }};

        Predicate<Integer> isTrue = x -> x > 0;

        for (Integer s : list) {
            if (isTrue.test(s)) {
                System.out.println(s);
            }
        }
    }
}
