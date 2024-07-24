package com.barros.hexagonal.adapters.in.controller;

import com.barros.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.barros.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.barros.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.barros.hexagonal.application.core.domain.Customer;
import com.barros.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.barros.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.barros.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.barros.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        insertCustomerInputPort.insert(customerMapper.toCustomer(request), request.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        final Customer customer = findCustomerByIdInputPort.find(id);
        final CustomerResponse customerResponse = customerMapper.toCostumerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/id")
    public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest request) {
        Customer customer = customerMapper.toCustomer(request);
        customer.setId(id);
        updateCustomerInputPort.update(customer, request.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
