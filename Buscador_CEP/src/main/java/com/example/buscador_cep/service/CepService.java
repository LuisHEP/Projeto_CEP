package com.example.buscador_cep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CepService {

    private final String URL_VIA_CEP = "https://viacep.com.br/ws/{cep}/json/";

    public String buscarCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(URL_VIA_CEP, String.class, cep);
    }
}
