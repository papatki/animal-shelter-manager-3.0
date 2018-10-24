package com.patrycja.model;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class AnimalData {

    private static int idValue = 1;
    private final List<Animal> animals = new ArrayList<>();

    public AnimalData() {
        addAnimal(new Animal("Rex", "dog", "Very friendly. Smart but sometimes lazy."));
        addAnimal(new Animal("Snowy", "cat", "Old and lazy."));
        addAnimal(new Animal("Foxy", "dog", "Kind and easy."));
    }

    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    public void addAnimal(@NonNull Animal toAdd) {

        toAdd.setId(idValue);
        animals.add(toAdd);
        idValue++;

    }

    public void removeAnimal(int id) {

        ListIterator<Animal> iterator = animals.listIterator();

        while (iterator.hasNext()) {
            Animal animal = iterator.next();

            if (animal.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public Animal getAnimal(int id) {

        for (Animal animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    public void updateItem(@NonNull Animal toUpdate) {
        ListIterator<Animal> iterator = animals.listIterator();

        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.equals(toUpdate)) {
                iterator.set(toUpdate);
                break;
            }
        }
    }

}
