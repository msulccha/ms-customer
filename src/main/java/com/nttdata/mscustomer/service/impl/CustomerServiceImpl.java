package com.nttdata.mscustomer.service.impl;


import com.nttdata.mscustomer.entity.Customer;
import com.nttdata.mscustomer.entity.TypeCustomer;
import com.nttdata.mscustomer.repository.CustomerRepository;
import com.nttdata.mscustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Mono<Customer> create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> update(Customer customer) {

        return customerRepository.findById(customer.getId())
                .flatMap( customerExistente -> {
                    return customerRepository.save(customer);
                })
                .switchIfEmpty( null);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return customerRepository.findById(id)
                .flatMap(
                        customerExistente -> customerRepository.delete(customerExistente)
                                .then(Mono.just(Boolean.TRUE))
                )
                .defaultIfEmpty(Boolean.FALSE);
    }

    @Override
    public Mono<TypeCustomer> findTypeCustomer(String id) {
        return null;
    }
}
