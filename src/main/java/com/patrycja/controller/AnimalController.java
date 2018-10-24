package com.patrycja.controller;

import com.patrycja.model.Animal;
import com.patrycja.model.AnimalData;
import com.patrycja.service.AnimalService;
import com.patrycja.util.AttributeNames;
import com.patrycja.util.Mappings;
import com.patrycja.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @ModelAttribute
    public AnimalData animalData() {
        return animalService.getData();
    }

    // http://localhost:8080/animal-shelter-manager-3.0/animals
    @GetMapping(Mappings.ANIMALS)
    public String animals() {
        return ViewNames.ANIMALS_LIST;
    }

    @GetMapping(Mappings.ADD_ANIMAL)
    public String addEditAnimal(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {

        log.info("Editing id = {}", id);
        Animal animal = animalService.getAnimal(id);

        if (animal == null) {
            animal = new Animal("", "", "");
        }
        model.addAttribute(AttributeNames.ANIMAL, animal);
        return ViewNames.ADD_ANIMAL;
    }

    @PostMapping(Mappings.ADD_ANIMAL)
    public String processAnimal(@ModelAttribute(AttributeNames.ANIMAL) Animal animal) {
        if (animal.getId() == 0) {
            animalService.addAnimal(animal);
        } else {
            animalService.updateAnimal(animal);
        }

        return "redirect:/" + Mappings.ANIMALS;
    }

    @GetMapping(Mappings.DELETE_ANIMAL)
    public String deleteAnimal(@RequestParam int id) {
        animalService.removeAnimal(id);
        return "redirect:/" + Mappings.ANIMALS;
    }

    @GetMapping(Mappings.VIEW_ANIMAL)
    public String viewAnimal(@RequestParam int id, Model model) {
        Animal animal = animalService.getAnimal(id);
        model.addAttribute(AttributeNames.ANIMAL, animal);
        return ViewNames.VIEW_ANIMAL;
    }


}
