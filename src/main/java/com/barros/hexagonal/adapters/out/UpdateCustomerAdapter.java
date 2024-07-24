package com.barros.hexagonal.adapters.out;

import com.barros.hexagonal.adapters.out.repository.CustomerRepository;
import com.barros.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.barros.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        final CustomerEntity customerEntity = customerEntityMapper.toCostumerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
