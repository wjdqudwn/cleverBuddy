package com.CleverBuddy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cleverbuddy.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
