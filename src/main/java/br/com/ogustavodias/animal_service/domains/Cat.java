package br.com.ogustavodias.animal_service.domains;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("cat")
public class Cat extends Animal {

}
