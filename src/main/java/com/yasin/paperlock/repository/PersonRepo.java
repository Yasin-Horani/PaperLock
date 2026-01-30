package com.yasin.paperlock.repository;

import com.yasin.paperlock.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
