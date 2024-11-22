package com.busanit501.helloworld.jdbcex;

import com.busanit501.helloworld.jdbcex.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDAOTest {
    private TodoDAO todoDAO;

    @BeforeEach
    public void ready(){
        todoDAO = new TodoDAO();
    }

  @Test
    public void getTime(){
      System.out.println("sql 전달 후, 시간조회 확인용 " + todoDAO.getTime());
  }
}
