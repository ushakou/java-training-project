package lesson15.task2;

/*
Задача 2:
Создать класс, который будет хранить в себе коллекцию с названиями животных.
Реализовать методы удаления и добавления животных по следующим правилам:
добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
объекта этого класса в main методе другого класса.
 */

public class Task2 {
    public static void main(String[] args) {

        Animals newAnimal = new Animals();

        newAnimal.addAnimal("Кот");
        newAnimal.addAnimal("Собака");
        newAnimal.addAnimal("Хомяк");
        newAnimal.addAnimal("Попугай");
        newAnimal.addAnimal("Енот");

        newAnimal.print();

        newAnimal.removeLastAnimal();

        newAnimal.print();

        newAnimal.removeLastAnimal();

        newAnimal.print();

    }
}
