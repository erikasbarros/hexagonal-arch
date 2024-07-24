package com.barros.hexagonal.config;

import com.barros.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.barros.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
