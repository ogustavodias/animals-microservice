package br.com.ogustavodias.animal_service.domains;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("dog")
public class Dog extends Animal {

}
