package com.jks.springbootrest1;

import com.jks.springbootrest1.dto.LoanRequestDTO;
import com.jks.springbootrest1.dto.LoanResponseDTO;
import com.jks.springbootrest1.entity.CustomerAccount;
import com.jks.springbootrest1.entity.Loan;
import com.jks.springbootrest1.repository.CustomerAccountRepository;
import com.jks.springbootrest1.repository.LoanRepository;
import com.jks.springbootrest1.service.LoanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @MockBean
    private LoanRepository loanRepository;

    @MockBean
    private CustomerAccountRepository customerRepo;

    @Test
    public void testApplyForLoan_success() {
        CustomerAccount customer = new CustomerAccount();
        customer.setId(1L);
        customer.setName("John Doe");

        Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(customer));

        LoanRequestDTO request = new LoanRequestDTO();
        request.setCustomerId(1L);
        request.setAmount(new BigDecimal("50000"));
        request.setTenureMonths(12);
        request.setType("Home");

        Loan loan = new Loan();
        loan.setId(101L);
        loan.setCustomerAccount(customer);
        loan.setAmount(request.getAmount());
        loan.setTenureMonths(request.getTenureMonths());
        loan.setStartDate(LocalDate.of(2023, 1, 1));
        loan.setType(request.getType());

        Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenReturn(loan);

        LoanResponseDTO response = loanService.applyForLoan(request);

        //Assertions.assertEquals(101L, response.getLoanId());
        Assertions.assertEquals("John Doe", response.getCustomerName());
        Assertions.assertEquals(new BigDecimal("50000"), response.getAmount());
    }
}

