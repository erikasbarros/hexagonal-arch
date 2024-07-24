package com.barros.hexagonal.adapters.out.client.mapper;

import com.barros.hexagonal.adapters.out.client.response.AddressResponse;
import com.barros.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse AddressResponse);
}
