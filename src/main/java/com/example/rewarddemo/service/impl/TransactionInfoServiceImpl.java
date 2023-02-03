package com.example.rewarddemo.service.impl;

import com.example.rewarddemo.pojo.entity.TransactionInfo;
import com.example.rewarddemo.repository.TransactionInfoRepository;
import com.example.rewarddemo.service.TransactionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {
    private final TransactionInfoRepository transactionInfoRepository;

    @Autowired
    public TransactionInfoServiceImpl(TransactionInfoRepository transactionInfoRepository) {
        this.transactionInfoRepository = transactionInfoRepository;
    }

    @Override
    public List<TransactionInfo> getTransactionsByCustomerId(Long id) {
        return transactionInfoRepository.findAllByCustomer_Id(id);
    }

    @Override
    public TransactionInfo addTransaction(TransactionInfo tx){
        return transactionInfoRepository.save(tx);
    }

    @Override
    public List<TransactionInfo> getTransactionsByCustomerIdAndDateRange(Long id, LocalDate fromDate, LocalDate toDate) {
        return transactionInfoRepository.findAllByTransactionDateBetweenAndCustomer_Id(fromDate, toDate, id);
    }


}
