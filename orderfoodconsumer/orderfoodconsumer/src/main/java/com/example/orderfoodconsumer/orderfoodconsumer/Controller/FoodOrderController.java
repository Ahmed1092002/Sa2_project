package com.example.orderfoodconsumer.orderfoodconsumer.Controller;

import com.example.orderfoodconsumer.orderfoodconsumer.Model.FoodOrder;
import com.example.orderfoodconsumer.orderfoodconsumer.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Food-Controller")
public class FoodOrderController {
    private FoodOrderService foodOrderService;
@Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @GetMapping("/AllFoodOrders")
    public List<FoodOrder> getAllFoodOrders()
    {
     return    foodOrderService.GetAllFoodOrder();


    }

    @GetMapping("/AllFoodIdOrders")
    public Optional<FoodOrder> getAllByIdFoodOrders(@RequestParam Integer id)
    {
      return   foodOrderService.GetAllByIdFoodOrder(id);


    }
}
