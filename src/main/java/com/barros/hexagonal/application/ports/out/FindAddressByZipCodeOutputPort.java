package com.barros.hexagonal.application.ports.out;

import com.barros.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
