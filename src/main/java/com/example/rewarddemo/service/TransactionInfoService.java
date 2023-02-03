package com.example.rewarddemo.service;

import com.example.rewarddemo.pojo.entity.TransactionInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public interface TransactionInfoService {
    List<TransactionInfo> getTransactionsByCustomerId(Long id);
    TransactionInfo addTransaction(TransactionInfo tx);

    List<TransactionInfo> getTransactionsByCustomerIdAndDateRange(Long customer_id, LocalDate fromDate, LocalDate toDate);
}
