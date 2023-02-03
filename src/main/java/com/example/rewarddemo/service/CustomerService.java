package com.example.rewarddemo.service;

import com.example.rewarddemo.pojo.entity.Customer;
import com.example.rewarddemo.pojo.entity.TransactionInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer getCustomerById(Long id);
    Customer getCustomerByName(String name);
    Customer addCustomer(Customer customer);
    void deleteCustomerById(Long id);
    Customer updateCustomerById(Long id, Customer newCustomer);
    List<TransactionInfo> getCustomerTransById(Long id);
}
