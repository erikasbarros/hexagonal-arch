package com.barros.hexagonal.adapters.out;

import com.barros.hexagonal.adapters.out.repository.CustomerRepository;
import com.barros.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        return customerRepository.findById(id).map(entity -> customerEntityMapper.toCostumer(entity));
    }
}
