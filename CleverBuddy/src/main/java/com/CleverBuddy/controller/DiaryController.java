package com.CleverBuddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService diaryService;

    @Autowired
    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public ResponseEntity<List<Diary>> getAllDiaries() {
        List<Diary> diaries = diaryService.getAllDiaries();
        return new ResponseEntity<>(diaries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Diary> createDiary(@Valid @RequestBody Diary diary) {
        Diary createdDiary = diaryService.saveDiary(diary);
        return new ResponseEntity<>(createdDiary, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diary> getDiaryById(@PathVariable Long id) {
        Diary diary = diaryService.getDiaryById(id);
        if (diary == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(diary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiary(@PathVariable Long id) {
        diaryService.deleteDiary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
