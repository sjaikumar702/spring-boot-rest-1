package com.jks.springbootrest1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class LoanControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetLoansForCustomer() throws Exception {
        mockMvc.perform(get("/api/loans/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").exists());
    }
}
