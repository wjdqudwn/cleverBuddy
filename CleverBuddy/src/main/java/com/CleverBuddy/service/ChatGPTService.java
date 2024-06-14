package com.CleverBuddy.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.json.JSONObject;

@Service
public class ChatGPTService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String getChatResponse(String prompt) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiKey);
        headers.add("Content-Type", "application/json");

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "text-davinci-003"); // 사용할 모델 지정
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 150);

        HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class);

        return extractResponseFromResponseBody(response.getBody());
    }

    private String extractResponseFromResponseBody(String responseBody) {
        // 실제 응답에서 ChatGPT의 텍스트 응답을 추출하는 로직을 구현합니다.
        JSONObject json = new JSONObject(responseBody);
        return json.getJSONArray("choices").getJSONObject(0).getString("text");
    }
}
