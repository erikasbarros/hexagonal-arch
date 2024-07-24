package com.barros.hexagonal.adapters.out.repository.mapper;

import com.barros.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.barros.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCostumerEntity(Customer costumer);

    Customer toCostumer(CustomerEntity customerEntity);

}
