package com.barros.hexagonal.adapters.in.consumer;

import com.barros.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.barros.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.barros.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "barros")
    public void receive(CustomerMessage message) {
        updateCustomerInputPort.update(customerMessageMapper.toCostumer(message), message.getZipCode());
    }
}
