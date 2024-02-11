package com.example.orderfoodconsumer.orderfoodconsumer.Service;

import com.example.orderfoodconsumer.orderfoodconsumer.Model.Dto.FoodOrderDto;
import com.example.orderfoodconsumer.orderfoodconsumer.Model.FoodOrder;
import com.example.orderfoodconsumer.orderfoodconsumer.Repository.FoodOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository, ModelMapper modelMapper) {
        this.foodOrderRepository = foodOrderRepository;
        this.modelMapper = modelMapper;
    }

    public void persistFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        if (foodOrderRepository.existsById(foodOrder.getId())){

          foodOrderRepository.save(foodOrder);


        }
        else {

            FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);

            log.info("food order persisted {}", foodOrderRepository.save(foodOrder));

        }

    }

    public void DeleteFoodOrder(FoodOrderDto foodOrderDto) {
   //  FoodOrder foodOrder= modelMapper.map(foodOrderDto, FoodOrder.class);
//        FoodOrder  DeleteFoodOrder ;

         //foodOrderRepository.delete(foodOrder);
        if (foodOrderRepository.existsById(foodOrderDto.getId()))
        {
            foodOrderRepository.deleteById(foodOrderDto.getId());

            log.info("food order Deleted {}");
        }
        else {

            log.info("food order is not exist");

        }



//        foodOrderRepository.deleteById(foodOrderDto.getId());
//
//         log.info("food order Deleted {}");



    }


    public List<FoodOrder> GetAllFoodOrder() {
      //  FoodOrder foodOrder= modelMapper.map(foodOrderDto, FoodOrder.class);
//        FoodOrder  DeleteFoodOrder ;
        log.info("food order persisted {}", foodOrderRepository.findAll());
     return   foodOrderRepository.findAll();

     //   log.info("food order Deleted {}", foodOrderRepository.findAll());
    }
    public Optional<FoodOrder> GetAllByIdFoodOrder(Integer id) {
        //FoodOrder foodOrder= modelMapper.map(foodOrderDto, FoodOrder.class);
//        FoodOrder  DeleteFoodOrder ;
        //foodOrderRepository.findById(id);
        log.info("food order persisted {}", foodOrderRepository.findById(id));

        return   foodOrderRepository.findById(id);

    }


    public void UpdateFoodOrder(FoodOrderDto foodOrderDto) {
        FoodOrder foodOrder = modelMapper.map(foodOrderDto, FoodOrder.class);
        // FoodOrder persistedFoodOrder =
          foodOrderRepository.save(foodOrder);

        log.info("food order persisted {}", foodOrderRepository.save(foodOrder));
    }




}