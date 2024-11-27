package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.TodoService;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Log4j2
public class FoodServiceTest {
    private FoodService foodService;

    @BeforeEach
    public void ready() {
        foodService = FoodService.INSTANCE;
    }

    @Test
    public void testInsert() throws SQLException {
        // 더미 데이터, 화면에서 전달 받은 TodoDTO
        FoodDTO foodDTO = FoodDTO.builder()
                .title("샘플음식1126")
                .dueDate(LocalDate.now())
                .build();
        foodService.register(foodDTO);
    }

//    @Test
//    public void testSelectAll() throws SQLException {
//        List<FoodDTO> dtoList = foodService.listAll();
//        for (FoodDTO foodDTO:dtoList) {
//            log.info(foodDTO);
//        }
//    }

}
