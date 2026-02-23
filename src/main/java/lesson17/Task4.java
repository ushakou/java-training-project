package lesson17;

/*
Задача 4:
Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
выводить сумму, переведенную сразу в доллары.
 */

import java.util.function.Consumer;

public class Task4 {
    public static void main(String[] args) {

        String str = "202.9 BYN";

        Consumer<String> convertAndPrint = s ->
                System.out.println(Double.parseDouble(s.split(" ")[0]) / 3.2);

        convertAndPrint.accept(str);
    }
}
