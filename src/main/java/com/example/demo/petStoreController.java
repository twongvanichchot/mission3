package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class petStoreController {

    @Autowired
    private com.example.demo.petService petService;

    //GET all pet
    @GetMapping("/pets")
    public List<pet> getPet() {
        return petService.getPet();
    }

    //GET specific pet by ID
    @GetMapping("/pets/{id}")
    public List<pet>  getPetById(@PathVariable String id) {
        return petService.getPetById(id);
    }

    //POST create new pet
    @PostMapping("/pets")
    public List<pet> createPet(@RequestBody pet pet) {
        petService.createPet(pet);
        return petService.getPet();
    }

    //PUT update pet
    @PutMapping("/pets/{id}")
    public List<pet> updatePet(@RequestBody pet pet, @PathVariable String id) {
        petService.updatePet(pet,id);
        return petService.getPet();
    }

    @DeleteMapping("/pets/{id}") //DELETE PET BY ID
    public Object deletePetById(@PathVariable String id) {
        petService.deletePetById(id);
        return petService.getPet();
    }
    @DeleteMapping("/pets/")  //DELETE ALL PETS
    public Object deletePets () {
        petService.deletePet();
        return petService.getPet();
    }

}