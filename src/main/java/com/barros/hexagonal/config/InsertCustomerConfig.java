package com.barros.hexagonal.config;

import com.barros.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.barros.hexagonal.adapters.out.InsertCustomerAdapter;
import com.barros.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.barros.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter
    ) {
        return new InsertCustomerUseCase(
                findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
