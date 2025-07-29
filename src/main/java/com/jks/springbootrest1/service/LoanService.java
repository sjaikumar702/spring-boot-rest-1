package com.jks.springbootrest1.service;

import com.jks.springbootrest1.dto.LoanRequestDTO;
import com.jks.springbootrest1.dto.LoanResponseDTO;
import com.jks.springbootrest1.entity.CustomerAccount;
import com.jks.springbootrest1.entity.Loan;
import com.jks.springbootrest1.repository.CustomerAccountRepository;
import com.jks.springbootrest1.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private CustomerAccountRepository customerRepo;

    public LoanResponseDTO applyForLoan(LoanRequestDTO request) {
        CustomerAccount customer = customerRepo.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Loan loan = new Loan();
        loan.setCustomerAccount(customer);
        loan.setAmount(request.getAmount());
        loan.setTenureMonths(request.getTenureMonths());
        loan.setStartDate(LocalDate.now());
        loan.setType(request.getType());

        loanRepository.save(loan);

        LoanResponseDTO response = new LoanResponseDTO();
        response.setLoanId(loan.getId());
        response.setCustomerName(customer.getName());
        response.setAmount(loan.getAmount());
        response.setStartDate(loan.getStartDate());
        response.setTenureMonths(loan.getTenureMonths());

        return response;
    }

    public List<LoanResponseDTO> getLoansForCustomer(Long customerId) {
        return loanRepository.findAll().stream()
                .filter(loan -> loan.getCustomerAccount().getId().equals(customerId))
                .map(loan -> new LoanResponseDTO(
                        loan.getId(),
                        loan.getCustomerAccount().getName(),
                        loan.getAmount(),
                        loan.getStartDate(),
                        loan.getTenureMonths()))
                .collect(Collectors.toList());
    }
}

