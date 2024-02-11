package com.example.orderfoodconsumer.orderfoodconsumer.Model.Dto;

import com.example.orderfoodconsumer.orderfoodconsumer.Model.FoodOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;


@Getter
@Setter
public class FoodOrderDto  {
    Integer id;
    String item;
    Double amount;
    Boolean Deleted ;
}