package com.alica.sampleapplication.feature;

import com.alica.sampleapplication.feature.entity.CustomerDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CustomerControler.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class CustomerControlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void customerSaveDetails() throws Exception {
        when(customerService.saveCustomerDetails(any())).thenReturn(new CustomerDetails());

        String jsonBody = "{\"firstName\": \"Akshay\",\n" +
                "  \"lastName\": \"Aryan\",\n" +
                "  \"dateOfBirth\": \"2024-05-08\"}";

        this.mockMvc.perform(post("/customerDetails/saveDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getCustomerDetailsTest() throws Exception {
        CustomerDetails customer1 = new CustomerDetails();
        CustomerDetails customer2 = new CustomerDetails();

        when(customerService.getAllCustomerDetails()).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get("/customerDetails/getCustomerDetails"))
                .andExpect(status().isOk());
    }



}
