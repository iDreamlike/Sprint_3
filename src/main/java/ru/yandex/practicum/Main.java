package ru.yandex.practicum;

import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        AnimalFarm farm = new AnimalFarm(new ArrayList<>(Arrays.asList(
                "DOG Тузик",
                "CAT Кеша",
                "HORSE Буян",
                "HORSE",
                "DOG Кеша",
                "COW Буренка",
                "HORSE Моргенштерн",
                "DRAGON Смертокрыл")));

        System.out.println("\n===== Задание 3. Методы добавления новых животных: =====");
        farm.addAnimal(Animal.CAT, "Мурзик");
        farm.addAnimal(Animal.HORSE);
        farm.addAnimal("Тортилла");
        System.out.println("\n===== Задание 2. Коллекция уникальных имен животных: =====");
        System.out.println(farm.uniqueNames());
        System.out.println("\n===== Задание 1. Формируем хеш-таблицу с количеством животных на ферме (метод countedAnimals): =====");
        System.out.println(farm.countedAnimals());
        System.out.println("\n===== Задание 4. Вывод информации о животных на ферме: =====");
        System.out.println(farm);
    }
}