package com.barros.hexagonal.config;

import com.barros.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.barros.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.barros.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.barros.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
