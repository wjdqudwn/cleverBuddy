package com.CleverBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleverbuddy.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
