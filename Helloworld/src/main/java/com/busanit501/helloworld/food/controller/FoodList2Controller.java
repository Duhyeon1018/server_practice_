package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.jdbcex.dto.TodoDTO;
import com.busanit501.helloworld.jdbcex.service.TodoService;


import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2 //log.info("이런 형식으로 출력한다."  Controller = Servlet 그리고 Controller 에서 일을 시키려면 Service에 의존하고
// Service는 DAO 하나에 연결됨 = 이걸 느슨한 결합이라고 함. 복잡하지 않게 하기 위해서 다 분리하느거임.
@WebServlet(name = "FoodList2Controller",urlPatterns = "/food/list2")

public class FoodList2Controller extends HttpServlet {
    //외주 일 시키기 = 누구한테? 서비스한테, 선언만
    private FoodService foodService = FoodService.INSTANCE;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        log.info("doGet FoodList2Controller 확인");
        try {
            //서비스에 외주 주고, 전체목록 리스트를 받아오는게 바로 밑에 한줄로 처리가능
            List<FoodDTO> foodList = FoodService.INSTANCE.listAll();

            //화면에 데이터 전달 + 화면에 데이터 탑재된 화면을 -> 웹 브라우저에 전달
            request.setAttribute("list", foodList);
            request.getRequestDispatcher("/WEB-INF/food/foodList2.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

