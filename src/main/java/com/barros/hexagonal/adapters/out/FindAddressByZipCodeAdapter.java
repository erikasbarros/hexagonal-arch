package com.barros.hexagonal.adapters.out;

import com.barros.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.barros.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.barros.hexagonal.adapters.out.client.response.AddressResponse;
import com.barros.hexagonal.application.core.domain.Address;
import com.barros.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        final AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
