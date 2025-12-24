package com.example.Request_Api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record InfoResponseDto(
        CepResponseDto cepResponseDto,
        WeatherResponseDto weatherResponseDto,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dateTime
) {
}
