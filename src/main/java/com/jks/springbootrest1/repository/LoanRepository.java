package com.jks.springbootrest1.repository;

import com.jks.springbootrest1.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
