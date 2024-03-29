package com.example.orderfoodproducer.orderfoodproducer.Service;

import com.example.orderfoodproducer.orderfoodproducer.Producer.Producer;
import com.example.orderfoodproducer.orderfoodproducer.model.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final Producer producer;

    @Autowired
    public FoodOrderService(Producer producer) {
        this.producer = producer;
    }

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {

        return producer.sendMessage(foodOrder);
    }
}