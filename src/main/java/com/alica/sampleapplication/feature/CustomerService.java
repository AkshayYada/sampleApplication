package com.alica.sampleapplication.feature;

import com.alica.sampleapplication.feature.dao.CustomerDao;
import com.alica.sampleapplication.feature.entity.CustomerDetails;
import com.alica.sampleapplication.feature.model.CustomerRequestBody;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;

    public  CustomerDetails saveCustomerDetails(CustomerRequestBody customerRequestBody){
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(customerRequestBody.getFirstName());
        customerDetails.setLastName(customerRequestBody.getLastName());
        customerDetails.setDateOfBirth(customerRequestBody.getDateOfBirth());
        return customerDao.save(customerDetails);
    }

    public Iterable<CustomerDetails> getAllCustomerDetails(){
        return customerDao.findAll();
    }
}
