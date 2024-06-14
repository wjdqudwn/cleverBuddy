package com.CleverBuddy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationService {

    private static final String DEEPL_API_URL = "https://api-free.deepl.com/v2/translate";
    private static final String AUTH_KEY = "your_deepl_auth_key";

    public String translateToEnglish(String text) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?auth_key=%s&text=%s&target_lang=EN", DEEPL_API_URL, AUTH_KEY, text);

        String response = restTemplate.getForObject(url, String.class);

        return extractTranslatedTextFromResponse(response);
    }

    private String extractTranslatedTextFromResponse(String response) {
        // 실제로 JSON 응답을 파싱하여 번역된 텍스트를 추출합니다.
        // 아래는 간단한 예시로, 적절한 JSON 파싱 로직을 추가해야 합니다.
        JSONObject jsonResponse = new JSONObject(response);
        return jsonResponse.getJSONArray("translations").getJSONObject(0).getString("text");
    }
}
