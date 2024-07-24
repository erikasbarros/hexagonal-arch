package com.barros.hexagonal.application.ports.in;

import com.barros.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipcode);
}
