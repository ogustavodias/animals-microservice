package br.com.ogustavodias.animal_service.controllers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/get-total-rescued-in-period")
  private Integer getTotalRescuedInPeriod(
      @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
      @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

    long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

    if (daysBetween > 365) {
      throw new IllegalArgumentException("The period between the dates must be less than 365 days");
    }

    return animalRepository.getTotalRescuedInPeriod(startDate, endDate);
  }

  @PostMapping
  private void save(@RequestBody Animal animal) {
    animalRepository.save(animal);
  }

}
