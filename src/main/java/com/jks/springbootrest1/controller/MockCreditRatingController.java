package com.jks.springbootrest1.controller;

import com.jks.springbootrest1.dto.CreditRatingRequest;
import com.jks.springbootrest1.dto.CreditRatingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/mock-external")
public class MockCreditRatingController {

    @PostMapping("/credit/score/check")
    public ResponseEntity<CreditRatingResponse> getScore(@RequestBody CreditRatingRequest request) {
        int score = 780; // Dummy logic
        String band = "EXCELLENT";
        double rate = 7.25;

        CreditRatingResponse response = new CreditRatingResponse();
        response.setCustomerId(request.getCustomerId());
        response.setLoanId(request.getLoanId());
        response.setCreditScore(score);
        response.setRatingBand(band);
        response.setInterestRate(rate);
        response.setEvaluatedAt(LocalDate.now());

        return ResponseEntity.ok(response);
    }
}

