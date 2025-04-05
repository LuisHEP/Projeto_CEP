package com.example.cepjavafxapp.service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class CepService {

    private static final String API_URL = "http://localhost:8080/api/cep/";

    public static Map<String, String> buscarCep(String cep) {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL + cep);
            try (CloseableHttpResponse response = client.execute(request)) {
                String json = EntityUtils.toString(response.getEntity());

                // Convertendo JSON para Map
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json, Map.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
