package com.louazri.webapplication.repository;

import com.louazri.webapplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    Person readByEmail(String email);
}
