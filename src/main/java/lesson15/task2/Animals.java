package lesson15.task2;

import java.util.LinkedList;

public class Animals {

    private LinkedList<String> animals = new LinkedList<>();

    public void addAnimal(String animal) {
        if (animal != null) {
            animals.add(0, animal);
            System.out.println("Животное: " + animal + " - добавлено.");
        } else {
            System.out.println("Животное не может быть равно null.");
        }
    }

    public String removeLastAnimal() {
        if (animals.isEmpty()) {
            System.out.println("Массив пуст!");
            return null;
        }
        String lastAnimal = animals.getLast();
        animals.removeLast();
        System.out.println("Удалено последнее животное: " + lastAnimal);
        return lastAnimal;
    }

    public void print() {
        System.out.println(animals);
    }
}
