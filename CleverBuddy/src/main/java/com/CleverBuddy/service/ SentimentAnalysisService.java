package com.CleverBuddy.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class SentimentAnalysisService {

    private static final String EMOTION_API_URL = "http://localhost:5000/analyze";

    public String analyzeEmotion(String text) {
        RestTemplate restTemplate = new RestTemplate();
        EmotionRequest request = new EmotionRequest(text);
        String response = restTemplate.postForObject(EMOTION_API_URL, request, String.class);
        return extractEmotionFromResponse(response);
    }

    private String extractEmotionFromResponse(String response) {
        JSONObject jsonResponse = new JSONObject(response);
        return jsonResponse.getString("emotion");
    }

    private static class EmotionRequest {
        private String text;

        public EmotionRequest(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
