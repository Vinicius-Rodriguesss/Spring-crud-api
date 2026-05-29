package com.viniciusdev.crud.dto;

import java.util.UUID;

public record TasksResponseDTO(UUID id, String title, String description) {
}
