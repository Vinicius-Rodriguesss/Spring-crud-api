package com.viniciusdev.crud.handlers;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorDTO(HttpStatus status, String message, LocalDateTime datetime) {
}
