package com.alica.sampleapplication.feature.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerRequestBody {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}
