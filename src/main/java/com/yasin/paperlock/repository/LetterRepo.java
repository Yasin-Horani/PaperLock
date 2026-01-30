package com.yasin.paperlock.repository;

import com.yasin.paperlock.model.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepo extends JpaRepository<Letter, Long> {
}
