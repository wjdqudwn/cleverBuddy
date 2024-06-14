package com.CleverBuddy.service;

import com.cleverbuddy.model.Diary;
import com.cleverbuddy.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final TranslationService translationService;
    private final SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    public DiaryService(DiaryRepository diaryRepository, TranslationService translationService, SentimentAnalysisService sentimentAnalysisService) {
        this.diaryRepository = diaryRepository;
        this.translationService = translationService;
        this.sentimentAnalysisService = sentimentAnalysisService;
    }

    public List<Diary> getAllDiaries() {
        return diaryRepository.findAll();
    }

    public Diary saveDiary(Diary diary) {
        String translatedText = translationService.translateToEnglish(diary.getContent());
        String emotion = sentimentAnalysisService.analyzeEmotion(translatedText);
        diary.setEmotion(emotion);
        return diaryRepository.save(diary);
    }

    public Diary getDiaryById(Long id) {
        return diaryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Diary not found with id " + id));
    }

    public void deleteDiary(Long id) {
        diaryRepository.deleteById(id);
    }
}
