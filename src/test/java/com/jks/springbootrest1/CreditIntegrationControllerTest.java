package com.jks.springbootrest1;

import com.jks.springbootrest1.dto.CreditRatingRequest;
import com.jks.springbootrest1.dto.CreditRatingResponse;
import com.jks.springbootrest1.service.CreditRatingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class CreditIntegrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditRatingService creditRatingService;

    @Test
    public void testCheckCreditScoreEndpoint() throws Exception {
        String requestJson = """
    {
      "customerId": "CUST789",
      "panNumber": "ABCDE1234F",
      "loanId": "LOAN123",
      "requestedAmount": 600000,
      "tenureMonths": 24
    }
    """;

        CreditRatingResponse mockResponse = new CreditRatingResponse();
        mockResponse.setCreditScore(750);
        mockResponse.setRatingBand("EXCELLENT");
        mockResponse.setInterestRate(7.5);

        when(creditRatingService.fetchRating(Mockito.any(CreditRatingRequest.class))).thenReturn(mockResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/credit/score/check")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.creditScore").value(750))
                .andExpect(jsonPath("$.ratingBand").value("EXCELLENT"))
                .andExpect(jsonPath("$.interestRate").value(7.5));
    }

}
