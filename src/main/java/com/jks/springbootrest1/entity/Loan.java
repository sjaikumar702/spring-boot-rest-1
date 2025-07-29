package com.jks.springbootrest1.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Data
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private BigDecimal amount;
    private LocalDate startDate;
    private Integer tenureMonths;

    @ManyToOne
    @JoinColumn(name = "customer_account_id")
    private CustomerAccount customerAccount;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    private List<MonthlyBalance> monthlyBalances;
}

