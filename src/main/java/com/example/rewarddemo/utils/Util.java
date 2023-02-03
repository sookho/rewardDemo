package com.example.rewarddemo.utils;

public class Util {
    public static int calcReward(int amount){
        if(amount >= 100){
            return 1 * (100-50) + 2 * (amount - 100);
        }
        if(amount >= 50){
            return 1 * (amount - 50);
        }
        return 0;
    }
}
