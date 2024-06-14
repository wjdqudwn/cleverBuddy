package com.CleverBuddy.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService {

    private final String apiUrl = "https://api.openai.com/v1/engines/davinci-codex/completions";
    private final String apiKey = "sk-proj-laE1Qitb77eUXtn3roX0T3BlbkFJbOKszrcr3Jqsztch7Rnt";

    public String getChatGPTResponse(String question) {
        RestTemplate restTemplate = new RestTemplate();
        // API 요청 로직
        // 이 부분은 API 요청 형식에 따라 다릅니다.
        return "ChatGPT 응답"; // 실제 API 응답을 반환
    }
}
