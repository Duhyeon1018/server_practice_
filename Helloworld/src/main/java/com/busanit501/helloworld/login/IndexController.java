package com.busanit501.helloworld.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexController",urlPatterns = "/")

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //업무 -> 화면으로 전달해주는거
        System.out.println("doGet.index가 출력이됨.");

        //이동할 화면만 수정해주면 됨
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(request,response);
    }
}
