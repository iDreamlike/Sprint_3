package ru.yandex.practicum;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AnimalFarm {
    private final List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> result = new HashMap<>();
        for (String farmAnimal : farmAnimals) {
            String[] wordsInString = farmAnimal.split(" ");
            try {
                Animal animal = Animal.valueOf(wordsInString[0]);
                result.put(animal, result.getOrDefault(animal, 0) + 1);
            } catch (IllegalArgumentException exception) {
                System.out.println("Please correct string '" + farmAnimal + "'. Incorrect input data.");
            }
        }
        return result;
    }

    public Set<String> uniqueNames() {
        Set<String> result = new HashSet<>();
        for (String farmAnimal : farmAnimals) {
            String[] wordsInString = farmAnimal.split(" ");
            try {
                result.add(wordsInString[1]);
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Please correct string '" + farmAnimal + "'. Incorrect input data.");
            }
        }
        return result;
    }

    public void addAnimal(Animal animal, String name) {
        farmAnimals.add(animal.toString() + " " + name);
        System.out.println("Добавили новое животное: " + animal + " " + name);
    }

    public void addAnimal(Animal animal) {
        farmAnimals.add(animal.toString() + " N");
        System.out.println("Добавили новое животное: " + animal + " N");
    }

    public void addAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED + " " + name);
        System.out.println("Добавили новое животное: " + Animal.NOT_DEFINED + " " + name);
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
