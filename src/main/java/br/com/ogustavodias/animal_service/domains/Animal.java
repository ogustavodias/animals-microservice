package br.com.ogustavodias.animal_service.domains;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "animalType")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Dog.class, name = "dog"),
    @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "animalType", discriminatorType = DiscriminatorType.STRING)
public abstract class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(nullable = false)
  private Integer estimatedAge;

  @Column(nullable = false)
  private String provisoryName;

  @Column(nullable = false)
  private String breed;

  @Column(nullable = false)
  private String resumeOfStateAtEntry;

  @Column(nullable = false)
  private String receptionist;

  @Column(nullable = false)
  private String animalSize;

  @Column(nullable = false)
  private Date entryDate;

  @Column
  private Date adoptionDate;

  @Column
  private Date deathDate;

  public Integer getId() {
    return id;
  }

  public Integer getEstimatedAge() {
    return estimatedAge;
  }

  public String getProvisoryName() {
    return provisoryName;
  }

  public String getBreed() {
    return breed;
  }

  public String getResumeOfStateAtEntry() {
    return resumeOfStateAtEntry;
  }

  public String getReceptionist() {
    return receptionist;
  }

  public String getAnimalSize() {
    return animalSize;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public Date getAdoptionDate() {
    return adoptionDate;
  }

  public Date getDeathDate() {
    return deathDate;
  }

  public void setEstimatedAge(Integer estimatedAge) {
    this.estimatedAge = estimatedAge;
  }

  public void setProvisoryName(String provisoryName) {
    this.provisoryName = provisoryName;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public void setResumeOfStateAtEntry(String resumeOfStateAtEntry) {
    this.resumeOfStateAtEntry = resumeOfStateAtEntry;
  }

  public void setReceptionist(String receptionist) {
    this.receptionist = receptionist;
  }

  public void setAnimalSize(String animalSize) {
    this.animalSize = animalSize;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  public void setAdoptionDate(Date adoptionDate) {
    this.adoptionDate = adoptionDate;
  }

  public void setDeathDate(Date deathDate) {
    this.deathDate = deathDate;
  }
}
