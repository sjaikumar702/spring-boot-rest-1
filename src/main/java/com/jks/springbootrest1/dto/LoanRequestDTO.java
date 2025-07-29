package com.jks.springbootrest1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestDTO {
    private Long customerId;
    private String type;
    private BigDecimal amount;
    private Integer tenureMonths;
}
