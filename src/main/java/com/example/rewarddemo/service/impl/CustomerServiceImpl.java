package com.example.rewarddemo.service.impl;

import com.example.rewarddemo.pojo.entity.Customer;
import com.example.rewarddemo.pojo.entity.TransactionInfo;
import com.example.rewarddemo.repository.CustomerRepository;
import com.example.rewarddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer getCustomerByName(String name) {
        return null;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {

    }

    @Override
    public Customer updateCustomerById(Long id, Customer newCustomer) {
        return null;
    }

    @Override
    public List<TransactionInfo> getCustomerTransById(Long id) {
        return null;
    }
}
