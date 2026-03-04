package com.example.aiassistant.controller;

import com.example.aiassistant.dto.CodeReviewRequest;
import com.example.aiassistant.dto.CodeReviewResponse;
import com.example.aiassistant.dto.ExplainRequest;
import com.example.aiassistant.dto.ExplainResponse;
import com.example.aiassistant.dto.SummarizeRequest;
import com.example.aiassistant.dto.SummarizeResponse;
import com.example.aiassistant.service.AiAssistantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class AiAssistantController {

    private final AiAssistantService aiAssistantService;

    @PostMapping("/summarize")
    public SummarizeResponse summarize(@Valid @RequestBody SummarizeRequest request) {
        String summary = aiAssistantService.summarizeText(request.getText());
        return new SummarizeResponse(summary);
    }

    @PostMapping("/explain")
    public ExplainResponse explain(@Valid @RequestBody ExplainRequest request) {
        String explanation = aiAssistantService.explainLikeImFive(request.getTopic());
        return new ExplainResponse(explanation);
    }

    @PostMapping("/code-review")
    public CodeReviewResponse codeReview(@Valid @RequestBody CodeReviewRequest request) {
        String review = aiAssistantService.reviewJavaCode(request.getCode());
        return new CodeReviewResponse(review);
    }
}
