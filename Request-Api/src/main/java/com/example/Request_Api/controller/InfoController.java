package com.example.Request_Api.controller;

import com.example.Request_Api.dto.CepResponseDto;
import com.example.Request_Api.dto.InfoResponseDto;
import com.example.Request_Api.dto.WeatherResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RestController
@RequestMapping("request")
public class InfoController {

    @GetMapping("/cep/{cep}")
    public CepResponseDto getCep(@PathVariable String cep) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CepResponseDto> response = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepResponseDto.class);

        return response.getBody();
    }

    @GetMapping("/weather/{city}")
    public WeatherResponseDto getWeather(@PathVariable String city) {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<WeatherResponseDto> response = restTemplate.getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=98a8b73d523a49b8c5a1e6efb2516b97&lang=pt_br", city), WeatherResponseDto.class);

        return response.getBody();
    }

    @GetMapping("/info/{cep}")
    public InfoResponseDto getInfo(@PathVariable String cep) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CepResponseDto> response_cep = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/", cep), CepResponseDto.class);
        ResponseEntity<WeatherResponseDto> response_weather = restTemplate.getForEntity(String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=98a8b73d523a49b8c5a1e6efb2516b97&lang=pt_br", response_cep.getBody().localidade()), WeatherResponseDto.class);


        return new InfoResponseDto(response_cep.getBody(), response_weather.getBody(), LocalDateTime.now());
    }


}
