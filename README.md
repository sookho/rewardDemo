# rewardDemo

Request:  
GET http://localhost:8080/api/reward/1/2023-01-01/2023-04-01

Return example:  
```
{
    "rewardPerMon": {
        "1": 180,
        "2": 270,
        "3": 180
    },
    "totalReward": 630,
    "userId": 1
}
```

Problem: GetMapping + RequestParam -> cannot execute the controller function???
