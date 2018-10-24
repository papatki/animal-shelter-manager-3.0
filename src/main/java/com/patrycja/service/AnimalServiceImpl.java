package com.patrycja.service;

import com.patrycja.model.Animal;
import com.patrycja.model.AnimalData;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Getter
    private final AnimalData data = new AnimalData();

    @Override
    public void addAnimal(Animal toAdd) {
        data.addAnimal(toAdd);

    }

    @Override
    public void removeAnimal(int id) {
        data.removeAnimal(id);
    }

    @Override
    public Animal getAnimal(int id) {
        return data.getAnimal(id);
    }

    @Override
    public void updateAnimal(Animal toUpdate) {
        data.updateItem(toUpdate);
    }

}
