package com.example.rewarddemo.repository;

import com.example.rewarddemo.pojo.entity.TransactionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TransactionInfoRepositoryTest {
    @Autowired
    private TransactionInfoRepository transactionInfoRepository;

    @Test
    void findAllByCustomer_Id() {
        List<TransactionInfo> list = transactionInfoRepository.findAllByCustomer_Id(1L);
        for (TransactionInfo tx : list){
            System.out.println(tx.getId() + " : " + tx.getAmount());
        }
    }

    @Test
    void findAllByTransactionDateBetweenAndCustomer_Id() {
        LocalDate fromDate = LocalDate.of(2023,1,1);
        LocalDate toDate = LocalDate.of(2023,4,1);
        List<TransactionInfo> list = transactionInfoRepository.findAllByTransactionDateBetweenAndCustomer_Id(fromDate, toDate, 1L);
        for (TransactionInfo tx : list){
            System.out.println(tx.getId() + " : " + tx.getAmount() + " date is: " + tx.getTransactionDate());
        }
    }

//    @Test
//    void findAllByTransactionDateAndCustomer_Id() {
//        LocalDate fromDate = LocalDate.of(2023,1,2);
//        TransactionInfo tx = transactionInfoRepository.findAllByTransactionDateAndCustomer_Id(fromDate, 1L);
//        System.out.println(tx.getId() + " : " + tx.getAmount() + " date is: " + tx.getTransactionDate());
//    }
}