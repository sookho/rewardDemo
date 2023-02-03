package com.example.rewarddemo.pojo.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class Reward {
    private Long UserId;
    private Map<Integer, Integer> rewardPerMon;
    private Integer totalReward;
}
