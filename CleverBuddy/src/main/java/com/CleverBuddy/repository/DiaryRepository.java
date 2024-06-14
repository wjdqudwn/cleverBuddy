package com.CleverBuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cleverbuddy.model.Diary;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
