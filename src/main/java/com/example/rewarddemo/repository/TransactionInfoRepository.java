package com.example.rewarddemo.repository;

import com.example.rewarddemo.pojo.entity.TransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long> {
//    List<TransactionInfo> findByTransactionDateBetween(Date startDate, Date endDate);
    List<TransactionInfo> findAllByCustomer_Id(Long customer_id);
    List<TransactionInfo> findAllByTransactionDateBetweenAndCustomer_Id(LocalDate fromDate, LocalDate toDate, Long customer_id);
//    TransactionInfo findAllByTransactionDateAndCustomer_Id(LocalDate fromDate, Long customer_id);
}
