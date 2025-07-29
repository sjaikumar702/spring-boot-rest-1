package com.jks.springbootrest1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {
    private Long loanId;
    private String customerName;
    private BigDecimal amount;
    private LocalDate startDate;
    private Integer tenureMonths;

}
