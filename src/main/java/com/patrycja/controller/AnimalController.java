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
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(Mappings.ANIMALS)
    public String animals() {
        return ViewNames.ANIMALS_LIST;
    }


    @RequestMapping(Mappings.ADD_ANIMAL)
    public String addAnimal(Model model) {
        model.addAttribute(AttributeNames.ANIMAL, new Animal("","",""));
        return ViewNames.ADD_ANIMAL;

    }

    @RequestMapping(value = Mappings.ADD_ANIMAL, method = RequestMethod.POST)
    public String processAnimal(Animal animal) {
        animalService.addAnimal(animal);

        return "redirect:/" + Mappings.ANIMALS;
    }



    @RequestMapping("/" + Mappings.EDIT_ANIMAL + "/{id}")
    public String editAnimal(@PathVariable int id, Model model){
        Animal animal = animalService.getAnimal(id);
        model.addAttribute(AttributeNames.ANIMAL,animal);
        return ViewNames.EDIT_ANIMAL;
    }

    @RequestMapping(value = Mappings.EDIT_ANIMAL, method = RequestMethod.POST)
    public String updateAnimal(Animal animal) {
        animalService.updateAnimal(animal);

        return "redirect:/" + Mappings.ANIMALS;
    }

    @RequestMapping("/" + Mappings.DELETE_ANIMAL + "/{id}")
    public String deleteAnimal(@PathVariable int id) {
        animalService.removeAnimal(id);
        return "redirect:/" + Mappings.ANIMALS;
    }

    @RequestMapping("/"+ Mappings.VIEW_ANIMAL+"/{id}")
    public String viewAnimal(@PathVariable int id, Model model) {
        Animal animal = animalService.getAnimal(id);
        model.addAttribute(AttributeNames.ANIMAL, animal);
        return ViewNames.VIEW_ANIMAL;
    }


}
