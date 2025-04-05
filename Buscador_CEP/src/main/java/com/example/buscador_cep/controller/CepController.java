package com.example.buscador_cep.controller;

import com.example.buscador_cep.service.CepService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cep")
@CrossOrigin("*")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public String getCep(@PathVariable String cep) {
        return cepService.buscarCep(cep);
    }
}
