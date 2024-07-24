package com.barros.hexagonal.application.ports.in;

import com.barros.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
