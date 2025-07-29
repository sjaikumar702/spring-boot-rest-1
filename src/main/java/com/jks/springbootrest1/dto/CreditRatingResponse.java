package com.jks.springbootrest1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
public class CreditRatingResponse {
    private String customerId;
    private String loanId;
    private int creditScore;
    private String ratingBand;
    private double interestRate;
    private LocalDate evaluatedAt;

}
