package com.alica.sampleapplication.feature.dao;

import com.alica.sampleapplication.feature.entity.CustomerDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<CustomerDetails, Long> {

    @Override
    <S extends CustomerDetails> S save(S entity);

    @Override
    Iterable<CustomerDetails> findAll();
}
