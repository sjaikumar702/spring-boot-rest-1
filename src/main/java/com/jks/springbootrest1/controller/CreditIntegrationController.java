package com.jks.springbootrest1.controller;

import com.jks.springbootrest1.dto.CreditRatingRequest;
import com.jks.springbootrest1.dto.CreditRatingResponse;
import com.jks.springbootrest1.service.CreditRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit")
public class CreditIntegrationController {

    @Autowired
    private CreditRatingService ratingService;

    @PostMapping("/score/check")
    public ResponseEntity<CreditRatingResponse> checkCredit(@RequestBody CreditRatingRequest request) {
        CreditRatingResponse response = ratingService.fetchRating(request);
        return ResponseEntity.ok(response);
    }
}

