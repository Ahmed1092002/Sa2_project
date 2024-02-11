package com.example.orderfoodconsumer.orderfoodconsumer.Repository;

import com.example.orderfoodconsumer.orderfoodconsumer.Model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {
    @Query("select u from FoodOrder u ")
    FoodOrder findByProductName( String productName);

}