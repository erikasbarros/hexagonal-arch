package com.barros.hexagonal.application.ports.in;

import com.barros.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
