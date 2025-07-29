package com.jks.springbootrest1.repository;

import com.jks.springbootrest1.entity.MonthlyBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyBalanceRepository extends JpaRepository<MonthlyBalance, Long> {
}
