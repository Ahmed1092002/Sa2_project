package com.example.orderfoodconsumer.orderfoodconsumer.Model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Food_Order")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String item;
    private Double amount;
    private Boolean Deleted;

}