package com.patrycja.service;

import com.patrycja.model.Animal;
import com.patrycja.model.AnimalData;

public interface AnimalService {

    void addAnimal(Animal toAdd);

    void removeAnimal(int id);

    Animal getAnimal(int id);

    void updateAnimal(Animal toUpdate);

    AnimalData getData();
}
