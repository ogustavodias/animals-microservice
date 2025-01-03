package br.com.ogustavodias.animal_service.repositorys;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ogustavodias.animal_service.domains.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
  @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NULL ORDER BY a.entryDate")
  List<Animal> findByNotAdopted();

  @Query("SELECT a FROM Animal a WHERE a.adoptionDate IS NOT NULL")
  List<Animal> findByAdopted();

  @Query("SELECT COUNT(a) FROM Animal a WHERE a.entryDate BETWEEN :startDate AND :endDate")
  Integer getTotalRescued(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
