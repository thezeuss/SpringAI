package com.example.aiassistant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiAssistantService {

    private final ChatClient chatClient;

    /**
     * Sends a summarization prompt to the LLM through Spring AI's ChatClient.
     */
    public String summarizeText(String text) {
        String prompt = """
                Summarize the following text in 2-4 concise sentences.
                Keep only key information and avoid extra commentary.

                Text:
                %s
                """.formatted(text);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    /**
     * Uses prompt engineering to force a child-friendly explanation.
     */
    public String explainLikeImFive(String topic) {
        String prompt = """
                Explain this topic as if you are talking to a 5-year-old.
                Use very simple words, short sentences, and a relatable analogy.
                End with one short practical example.

                Topic:
                %s
                """.formatted(topic);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    /**
     * Requests structured code review feedback from the LLM.
     */
    public String reviewJavaCode(String code) {
        String prompt = """
                You are a senior Java reviewer.
                Review the following Java code snippet and provide:
                1) Potential bugs
                2) Readability improvements
                3) Performance suggestions (if any)
                4) Best-practice recommendations

                Keep the response concise and actionable.

                Code:
                %s
                """.formatted(code);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
