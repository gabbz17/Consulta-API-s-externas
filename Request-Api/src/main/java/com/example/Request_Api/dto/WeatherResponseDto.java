package com.example.Request_Api.dto;

import java.util.List;

public record WeatherResponseDto(
        List<ResponseWeatherDto> weather ,
        ResponseSysDto sys,
        String timezone,
        String name,
        String cod
) {
}
