package com.CleverBuddy.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class SentimentAnalysisService {

    public String analyzeSentiment(String text) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "path/to/abc.py", text);
            Process process = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "감정 분석 실패";
        }
    }
}
