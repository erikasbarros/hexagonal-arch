package com.barros.hexagonal.application.core.usecase;

import com.barros.hexagonal.application.core.domain.Address;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.barros.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.barros.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort fIndAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = fIndAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode) {
        Address address = findAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
