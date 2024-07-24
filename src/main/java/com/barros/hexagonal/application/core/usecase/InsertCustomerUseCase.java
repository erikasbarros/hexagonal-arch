package com.barros.hexagonal.application.core.usecase;

import com.barros.hexagonal.application.core.domain.Address;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.barros.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.barros.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.barros.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort fIndAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = fIndAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode) {
        Address address = findAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
