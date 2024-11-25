package com.busanit501.helloworld.dao.jdbcex;

import com.busanit501.helloworld.food.VO.FoodVO;
import com.busanit501.helloworld.food.dao.FoodDAO;
import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import com.busanit501.helloworld.jdbcex.vo.TodoVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
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
}
