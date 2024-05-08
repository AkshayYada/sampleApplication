package com.alica.sampleapplication.feature;

import com.alica.sampleapplication.feature.entity.CustomerDetails;
import com.alica.sampleapplication.feature.model.CustomerRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerDetails")
@RequiredArgsConstructor
public class CustomerControler {

    private final CustomerService customerService;

    @PostMapping("/saveDetails")
    public ResponseEntity<CustomerDetails> saveCustomerDetails(@RequestBody CustomerRequestBody customerRequestBody){
        return ResponseEntity.ok(customerService.saveCustomerDetails(customerRequestBody));
    }

    @GetMapping("/getCustomerDetails")
    public Iterable<CustomerDetails> getCustomerDetails(){
        return customerService.getAllCustomerDetails();
    }


}
