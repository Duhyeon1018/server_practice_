package com.busanit501.helloworld.dao.jdbcex;

import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class FoodDAOTest {
    private FoodDAO foodDAO;

    @BeforeEach
    public void ready() {
        foodDAO = new FoodDAO();
    }

    @Test
    public void testList() throws SQLException {
        List<FoodVO> list = foodDAO.selectAll();
        list.forEach(vo -> System.out.println(vo));
    }

    //3, 하나 조회 테스트
    @Test
    public void getOneTest() throws SQLException {
        Long tno = 2L;
        FoodVO foodVO = foodDAO.selectOne(tno);
        System.out.println(foodVO);
    }

    //4, 삭제테스트
    @Test
    public void deleteTest() throws SQLException {
        Long tno = 1L;
        foodDAO.deleteFood(tno);


    }

    //5, 수정테스트
    @Test
    public void updateTest() throws SQLException {
        //실제 작업은 내용을 화면에서 받아옴, 그치만 못하지만
        //화면에서 받아오는 대신 하드코딩으로 값을 더미로 테스트 진행
        FoodVO foodVO = FoodVO.builder()
                .tno(3L)
                .title("음식수정테스트")
                .finished(true)
                .dueDate(LocalDate.of(2024, 12, 25))
                .build();
        foodDAO.updateOne(foodVO);

    }
}
