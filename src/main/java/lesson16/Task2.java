package lesson16;

/*
Задача 2:
На вход поступает массив непустых строк, создайте и верните Map<String,
String> следующим образом: для каждой строки добавьте ее первый символ в
качестве ключа с последним символом в качестве значения. Пример:
pairs(["code", "bug"]) → {"b": "g", "c": "e"}
pairs(["man", "moon", "main"]) → {"m": "n"}
pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {

        String[] array = {"man", "moon", "main"};

        System.out.println("Имеем следующий массив:");
        System.out.println(Arrays.toString(array));

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            map.put(String.valueOf(str.charAt(0)), String.valueOf(str.charAt(str.length() - 1)));
        }

        System.out.println("Получили следующую Map:");
        System.out.println(map);

    }
}
