package com.aref.vector_search.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aref.vector_search.model.EmbeddingResponse;


@Service
public class EmbeddingService {

    private static final String URL = "http://localhost:5000/embed";
    
    public List<Double> embedd(String inpuString) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("texts", Arrays.asList(inpuString));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<EmbeddingResponse> response = restTemplate.postForEntity(URL, entity, EmbeddingResponse.class);

        return response.getBody().getEmbeddings().getFirst();
    }

}
