package com.CleverBuddy.service;

import com.cleverbuddy.model.Diary;
import com.cleverbuddy.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public List<Diary> getAllDiariesByUserId(Long userId) {
        return diaryRepository.findByUserId(userId);
    }

    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id).orElse(null);
    }

    public Diary createDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public Diary updateDiary(Diary diary) {
        return diaryRepository.save(diary);
    }

    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }
}
