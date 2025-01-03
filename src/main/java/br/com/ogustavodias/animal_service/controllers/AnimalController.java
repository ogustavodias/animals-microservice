package br.com.ogustavodias.animal_service.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ogustavodias.animal_service.domains.Animal;
import br.com.ogustavodias.animal_service.repositorys.AnimalRepository;

@RestController
@RequestMapping("/animals")
public class AnimalController {
  
  private AnimalRepository animalRepository;

  public AnimalController(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @GetMapping
  private List<Animal> findAll() {
    return animalRepository.findAll();
  };

  @GetMapping("/not-adopted")
  private List<Animal> findByNotAdopted() {
    return animalRepository.findByNotAdopted();
  }

  @GetMapping("/adopted")
  private List<Animal> findByAdopted() {
    return animalRepository.findByAdopted();
  }

  @PostMapping
  private void save(@RequestBody Animal animal) {
    animalRepository.save(animal);
  }

}
