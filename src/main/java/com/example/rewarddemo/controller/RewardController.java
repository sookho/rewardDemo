package com.example.rewarddemo.controller;

import com.example.rewarddemo.pojo.DTO.Reward;
import com.example.rewarddemo.pojo.entity.Customer;
import com.example.rewarddemo.pojo.entity.TransactionInfo;
import com.example.rewarddemo.service.CustomerService;
import com.example.rewarddemo.service.TransactionInfoService;
import com.example.rewarddemo.service.impl.CustomerServiceImpl;
import com.example.rewarddemo.service.impl.TransactionInfoServiceImpl;
import com.example.rewarddemo.utils.Util;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequestMapping("api")
public class RewardController {
    private final TransactionInfoService transactionInfoService;
    private final CustomerService customerService;

    @Autowired
    public RewardController(TransactionInfoService transactionInfoService, CustomerService customerService) {
        this.transactionInfoService = transactionInfoService;
        this.customerService = customerService;
    }

    @GetMapping("reward/{id}/{from}/{to}")
    public ResponseEntity<Reward> getRewardByCustomerId(@PathVariable("id") Long id,
                                                        @PathVariable("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                        @PathVariable("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate){
        log.info("info getRewardByCustomerId");

//        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate
        List<TransactionInfo> list = transactionInfoService.getTransactionsByCustomerIdAndDateRange(id, fromDate, toDate);

        Reward reward = new Reward();
        reward.setUserId(id);
        Map<Integer, Integer> map = new HashMap<>();
        int totalReward = 0;
        for(TransactionInfo tx : list){
            LocalDate txDate = tx.getTransactionDate();
            int month = txDate.getMonthValue();
            map.put(month, map.getOrDefault(month, 0) + tx.getReward());
            totalReward += tx.getReward();
        }
        reward.setTotalReward(totalReward);
        reward.setRewardPerMon(map);
        return ResponseEntity.ok().body(reward);
    }

//    @GetMapping("reward/{id}")
//    public ResponseEntity<List<TransactionInfo>> getRewardByCustomerId(@PathVariable("id") Long id){
//        List<TransactionInfo> list = transactionInfoService.getTransactionsByCustomerId(id);
//        log.info("getRewardByCustomerId");
//        return ResponseEntity.ok().body(list);
//    }

    @PostMapping("trans")
    public ResponseEntity<TransactionInfo> addTrans(@RequestParam("amount") int amount,
                                                    @RequestParam("id") Long userId,
                                                    @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        Customer cus = customerService.getCustomerById(userId);
        TransactionInfo tx = new TransactionInfo();
        tx.setAmount(amount);
        tx.setCustomer(cus);
        tx.setTransactionDate(date);
        tx.setReward(Util.calcReward(amount));
        return new ResponseEntity<>(transactionInfoService.addTransaction(tx), HttpStatus.CREATED);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer cus = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(cus);
    }
}
