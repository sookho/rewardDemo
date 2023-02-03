package com.example.rewarddemo.service.impl;

import com.example.rewarddemo.pojo.entity.TransactionInfo;
import com.example.rewarddemo.repository.TransactionInfoRepository;
import com.example.rewarddemo.service.TransactionInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionInfoServiceImplTest {
    @InjectMocks
    private TransactionInfoServiceImpl transactionInfoService;

    @Mock
    private TransactionInfoRepository transactionInfoRepository;

    @Test
    void getTransactionsByCustomerIdAndDateRange() {
        LocalDate fromDate = LocalDate.of(2023,1,1);
        LocalDate toDate = LocalDate.of(2023,4,1);
//        List<TransactionInfo> list = transactionInfoService.getTransactionsByCustomerIdAndDateRange(1L,fromDate,toDate);
        List<TransactionInfo> list = transactionInfoService.getTransactionsByCustomerId(1L);
        if(list.isEmpty()){
            System.out.println("it is empty");
        }else{
            for (TransactionInfo tx : list){
                System.out.println(tx.getId() + " : " + tx.getAmount() + " date is: " + tx.getTransactionDate());
            }
        }
    }

    @Test
    void getTransactionsByCustomerId() {
    }
}