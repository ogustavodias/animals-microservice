package br.com.ogustavodias.animal_service.repositorys;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ogustavodias.animal_service.domains.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  Animal findByProvisoryName(String provisoryName);

  List<Animal> findByBreed(String breed);

  List<Animal> findByReceptionist(String receptionist);

  List<Animal> findByAnimalSize(String animalSize);

  List<Animal> findByEntryDate(Date entryDate);

  List<Animal> findByAdoptionDate(Date adoptionDate);

  List<Animal> findByDeathDate(Date deathDate);
}
