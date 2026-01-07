package com.example.Request_Api.controller;

import com.example.Request_Api.Service.InfoService;
import com.example.Request_Api.dto.CepResponseDto;
import com.example.Request_Api.dto.InfoResponseDto;
import com.example.Request_Api.dto.WeatherResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("request")
public class InfoController {

    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping("/cep/{cep}")
    public CepResponseDto getCep(@PathVariable String cep) {
        return service.getCep(cep);
    }

    @GetMapping("/weather/{city}")
    public WeatherResponseDto getWeather(@PathVariable String city) {
        return service.getWeather(city);
    }

    @GetMapping("/info/{cep}")
    public InfoResponseDto getInfo(@PathVariable String cep) {
        return service.getInfo(cep);
    }
}
