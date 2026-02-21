package lesson16;

/*
Задача 1:
На вход поступает массив строк, верните Map<String, Boolean>, где каждая отдельная
строка является ключом, и ее значение равно true, если эта строка встречается в массиве
2 или более раз. Пример:
wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
wordMultiple(["c", "c", "c", "c"]) → {"c": true}
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {

        String[] array = {"c", "c", "c", "c"};

        System.out.println("Имеем следующий массив:");
        System.out.println(Arrays.toString(array));

        Map<String, Boolean> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            String str = array[i];

            boolean foundDuplicate = false;
            for (int j = 0; j < array.length; j++) {
                if (i != j && str.equals(array[j])) {
                    foundDuplicate = true;
                    break;
                }
            }

            if (foundDuplicate) {
                map.put(str, true);
            } else if (!map.containsKey(str)) {
                map.put(str, false);
            }
        }

        System.out.println("Получили следующую Map:");
        System.out.println(map);

    }
}
