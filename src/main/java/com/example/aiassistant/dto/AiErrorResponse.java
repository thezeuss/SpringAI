package com.example.aiassistant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiErrorResponse {

    private String error;
    private String message;
    private Instant timestamp;
}
