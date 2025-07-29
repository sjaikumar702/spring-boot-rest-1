package com.jks.springbootrest1.controller;

import com.jks.springbootrest1.dto.LoanRequestDTO;
import com.jks.springbootrest1.dto.LoanResponseDTO;
import com.jks.springbootrest1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanResponseDTO> applyForLoan(@RequestBody LoanRequestDTO request) {
        LoanResponseDTO response = loanService.applyForLoan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<LoanResponseDTO>> getLoansForCustomer(@PathVariable Long customerId) {
        List<LoanResponseDTO> loans = loanService.getLoansForCustomer(customerId);
        return ResponseEntity.ok(loans);
    }
}

