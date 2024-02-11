package com.example.orderfoodconsumer.orderfoodconsumer.Consumer;

import com.example.orderfoodconsumer.orderfoodconsumer.Model.Dto.FoodOrderDto;
import com.example.orderfoodconsumer.orderfoodconsumer.Service.FoodOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final FoodOrderService foodOrderService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, FoodOrderService foodOrderService) {
        this.objectMapper = objectMapper;
        this.foodOrderService = foodOrderService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        FoodOrderDto foodOrderDto = objectMapper.readValue(message, FoodOrderDto.class);
        if (foodOrderDto.getDeleted()==true)
        {
            foodOrderService.DeleteFoodOrder(foodOrderDto);
        }
        else {
            foodOrderService.persistFoodOrder(foodOrderDto);
        }





    }

}