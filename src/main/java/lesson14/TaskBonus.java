package lesson14;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Задача *:
Допустим есть txt файл с номерами документов. Номером документа является строка,
состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит каждый
номер документа с новой строки и в строке никакой другой информации, только номер
документа. Валидный номер документа должен иметь длину 15 символов и начинаться с
последовательности docnum(далее любая последовательность букв/цифр) или
contract(далее любая последовательность букв/цифр). Написать программу для чтения
информации из входного файла - путь к входному файлу должен задаваться через
консоль. Программа должна проверять номера документов на валидность. Валидные
номера документов следует записать в один файл-отчет. Невалидные номера документов
следует записать в другой файл-отчет, но после номеров документов следует добавить
информацию о том, почему этот документ не валиден.
 */

public class TaskBonus {
    public static void main(String[] args) {

        //Reading the file path from the console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String inputPath = scanner.nextLine().trim();

        Path inputDir = Paths.get(inputPath).getParent();
        if (inputDir == null) {
            System.err.println("Не удалось определить папку входного файла.");
            return;
        }

        String validPath = inputDir.resolve("valid-docnum.txt").toString();
        String invalidPath = inputDir.resolve("invalid-docnum.txt").toString();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));
             BufferedWriter validWriter = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(validPath), StandardCharsets.UTF_8));
             BufferedWriter invalidWriter = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(invalidPath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                String reason = validateDocumentNumber(line);
                if (reason == null) {
                    validWriter.write(line + "\n");
                } else {
                    invalidWriter.write(line + " - " + reason + "\n");
                }
            }

            System.out.println("Валидные номера записаны в файл: " + validPath);
            System.out.println("Невалидные номера записаны в файл: " + invalidPath);

        } catch (FileNotFoundException e) {
            System.err.println("Ошибка чтения файла. Файл отсутствует.");
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static String validateDocumentNumber(String number) {
        if (number.length() != 15) {
            return "Неправильная длина (должна быть 15 символов)";
        }

        boolean startsWithDocnum = number.startsWith("docnum");
        boolean startsWithContract = number.startsWith("contract");

        if (!startsWithDocnum && !startsWithContract) {
            return "Не начинается с 'docnum' или 'contract'";
        }

        for (char c : number.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return "Содержит недопустимые символы.";
            }
        }

        return null;
    }
}
