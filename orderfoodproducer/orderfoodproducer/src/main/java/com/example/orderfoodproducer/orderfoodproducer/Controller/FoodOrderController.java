package com.example.orderfoodproducer.orderfoodproducer.Controller;

import com.example.orderfoodproducer.orderfoodproducer.Service.FoodOrderService;
import com.example.orderfoodproducer.orderfoodproducer.model.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/order")
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping("/foodOrder")
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }

    @DeleteMapping ("/DeltefoodOrder")
    public String DeleteFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        log.info("create food order request received");
        foodOrder.setDeleted(true);
        return foodOrderService.createFoodOrder(foodOrder);
    }
}