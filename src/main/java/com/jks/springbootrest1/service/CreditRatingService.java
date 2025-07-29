package com.jks.springbootrest1.service;

import com.jks.springbootrest1.dto.CreditRatingRequest;
import com.jks.springbootrest1.dto.CreditRatingResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CreditRatingService {

    private final WebClient webClient;

    public CreditRatingService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8080/mock-external").build();
    }

    public CreditRatingResponse fetchRating(CreditRatingRequest request) {
        return webClient.post()
                .uri("/credit/score/check")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(CreditRatingResponse.class)
                .block();
    }
}

