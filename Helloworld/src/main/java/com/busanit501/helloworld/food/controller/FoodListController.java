package com.busanit501.helloworld.food.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodListController",urlPatterns = "/food/list")
public class FoodListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //화면 전달.
        //방법1
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/todoList.jsp");
//        dispatcher.forward(request,response);
        //방법2
        request.getRequestDispatcher("/WEB-INF/food/foodList.jsp")
                .forward(request, response);
    }
}