package lesson17;

/*
Задача 3:
Используя Function реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
возвращать сумму, переведенную сразу в доллары.
 */

import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {

        String str = "102.9 BYN";

        Function<String, Double> exchange = s -> Double.parseDouble(s.split(" ")[0]) / 3.2;
        System.out.println(exchange.apply(str));
    }
}
