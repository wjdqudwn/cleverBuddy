package com.CleverBuddy.controller;

import com.CleverBuddy.model.Diary;
import com.cleverbuddy.service.DiaryService;
import com.cleverbuddy.service.SentimentAnalysisService;
import com.cleverbuddy.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @GetMapping("/user/{userId}")
    public List<Diary> getDiariesByUserId(@PathVariable Long userId) {
        return diaryService.getAllDiariesByUserId(userId);
    }

    @GetMapping("/{id}")
    public Diary getDiaryById(@PathVariable Long id) {
        return diaryService.getDiaryById(id);
    }

    @PostMapping
    public Diary writeDiary(@RequestBody Diary diary) {

        String translatedText = translationService.translateToEnglish(diary.getContent());

        String sentiment = sentimentAnalysisService.analyzeSentiment(translatedText);
        diary.setSentiment(sentiment);
        return diaryService.saveDiary(diary);
    }

    @PutMapping("/{id}")
    public Diary updateDiary(@PathVariable Long id, @RequestBody Diary diary) {
        diary.setId(id);
        return diaryService.updateDiary(diary);
    }

    @DeleteMapping("/{id}")
    public void deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
    }
}
