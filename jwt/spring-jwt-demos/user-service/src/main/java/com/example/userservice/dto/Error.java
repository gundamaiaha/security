package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Error {
    private String errorMessage;
    private Instant occurredAt;
}
