CREATE TABLE
  animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_type VARCHAR(255) NOT NULL,
    estimated_age INT NOT NULL,
    provisory_name VARCHAR(255) NOT NULL,
    breed VARCHAR(255) NOT NULL,
    resume_of_state_at_entry VARCHAR(255) NOT NULL,
    receptionist VARCHAR(255) NOT NULL,
    animal_size VARCHAR(255) NOT NULL,
    entry_date DATE NOT NULL,
    adoption_date DATE,
    death_date DATE
  );