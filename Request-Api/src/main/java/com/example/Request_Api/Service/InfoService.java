package com.example.Request_Api.Service;

import com.example.Request_Api.dto.CepResponseDto;
import com.example.Request_Api.dto.InfoResponseDto;
import com.example.Request_Api.dto.WeatherResponseDto;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class InfoService {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public CepResponseDto getCep(String cep) {
        ResponseEntity<CepResponseDto> response = restTemplate().getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepResponseDto.class);
        return response.getBody();
    }

    public WeatherResponseDto getWeather(String city){
        ResponseEntity<WeatherResponseDto> response = restTemplate().getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=&lang=pt_br", city), WeatherResponseDto.class);
        return response.getBody();
    }

    public InfoResponseDto getInfo(String cep) {
        ResponseEntity<CepResponseDto> response_cep = restTemplate().getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepResponseDto.class);
        ResponseEntity<WeatherResponseDto> response_weather = restTemplate().getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=&lang=pt_br", response_cep.getBody().localidade()), WeatherResponseDto.class);
        return new InfoResponseDto(response_cep.getBody(), response_weather.getBody(), LocalDateTime.now());
    }
}
