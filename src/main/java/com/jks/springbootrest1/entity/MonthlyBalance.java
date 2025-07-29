package com.jks.springbootrest1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Entity
public class MonthlyBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private BigDecimal principalRemaining;
    private BigDecimal interestAccrued;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;
}
