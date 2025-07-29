package com.jks.springbootrest1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class CreditRatingRequest {
    private String customerId;
    private String panNumber;
    private String loanId;
    private BigDecimal requestedAmount;
    private int tenureMonths;
}

