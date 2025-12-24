package com.example.Request_Api.dto;

public record CepResponseDto(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String estado,
        String regiao,
        String ddd
) {
}
