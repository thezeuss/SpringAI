package com.example.aiassistant.controller;

import com.example.aiassistant.dto.AiErrorResponse;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NonTransientAiException.class)
    public ResponseEntity<AiErrorResponse> handleAiException(NonTransientAiException ex) {
        String rawMessage = ex.getMessage() == null ? "" : ex.getMessage();

        if (rawMessage.contains("insufficient_quota")) {
            AiErrorResponse response = new AiErrorResponse(
                    "AI_QUOTA_EXCEEDED",
                    "OpenAI quota is exhausted. Add credits or increase your OpenAI plan/billing limit, then retry.",
                    Instant.now()
            );
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(response);
        }

        AiErrorResponse response = new AiErrorResponse(
                "AI_REQUEST_FAILED",
                "AI request failed. Please retry shortly.",
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
    }
}
