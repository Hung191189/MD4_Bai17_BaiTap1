package com.example.md4_bai17_baitap1.service.impl;

import com.example.md4_bai17_baitap1.model.Customers;
import com.example.md4_bai17_baitap1.repository.ICustomerRepository;
import com.example.md4_bai17_baitap1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Iterable<Customers> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customers> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customers customers) {
        customerRepository.save(customers);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
