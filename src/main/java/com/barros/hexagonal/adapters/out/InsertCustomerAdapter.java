package com.barros.hexagonal.adapters.out;

import com.barros.hexagonal.adapters.out.repository.CustomerRepository;
import com.barros.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toCostumerEntity(customer));
    }
}
