package com.barros.hexagonal.application.ports.out;

import com.barros.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
