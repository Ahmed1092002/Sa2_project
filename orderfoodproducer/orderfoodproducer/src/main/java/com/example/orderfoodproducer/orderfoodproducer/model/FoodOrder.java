package com.example.orderfoodproducer.orderfoodproducer.model;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {
    Integer id;
    String item;
    Double amount;

    Boolean Deleted;
}