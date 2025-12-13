package ru.yandex.practicum;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AnimalFarm {
    private final List<String> farmAnimals;
    private final String INCORRECT_INPUT_MESSAGE = "Please correct string '%s'. Incorrect input data.";
    private final String SUCCESS_ADDING_ANIMAL_MESSAGE = "Добавили новое животное:";

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> result = new HashMap<>();
        for (String farmAnimal : farmAnimals) {
            try {
                Animal animal = extractAnimal(farmAnimal);
                result.put(animal, countOfAnimals(result, animal));
            } catch (IllegalArgumentException exception) {
                System.out.printf(INCORRECT_INPUT_MESSAGE, farmAnimal);
            }
        }
        return result;
    }

    private static Animal extractAnimal(String farmAnimal) {
        String[] wordsInString = farmAnimal.split(" ");
        return Animal.valueOf(wordsInString[0]);
    }

    private static int countOfAnimals(Map<Animal, Integer> result, Animal animal) {
        return result.getOrDefault(animal, 0) + 1;
    }

    public Set<String> uniqueNames() {
        Set<String> result = new HashSet<>();
        for (String farmAnimal : farmAnimals) {
            try {
                extractName(farmAnimal, result);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.printf(INCORRECT_INPUT_MESSAGE, farmAnimal);
            }
        }
        return result;
    }

    private static void extractName(String farmAnimal, Set<String> result) {
        String[] wordsInString = farmAnimal.split(" ");
        result.add(wordsInString[1]);
    }

    public void addAnimal(Animal animal, String name) {
        farmAnimals.add(formatAnimal(animal, name));
        System.out.printf("%s %s %s\n", SUCCESS_ADDING_ANIMAL_MESSAGE, animal, name);
    }

    public void addAnimal(Animal animal) {
        farmAnimals.add(formatAnimal(animal,"N"));
        System.out.printf("%s %s N\n", SUCCESS_ADDING_ANIMAL_MESSAGE , animal);
    }

    public void addAnimal(String name) {
        farmAnimals.add(formatAnimal(Animal.NOT_DEFINED, name));
        System.out.printf("%s %s %s\n", SUCCESS_ADDING_ANIMAL_MESSAGE, Animal.NOT_DEFINED, name);
    }

    private static String formatAnimal(Animal type, String name) {
        return type + " " + name;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (String str : farmAnimals) {
            result.append(str);
            result.append("\n");
        }
        return result.toString();
    }
}
