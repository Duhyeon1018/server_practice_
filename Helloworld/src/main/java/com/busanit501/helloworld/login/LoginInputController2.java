package com.busanit501.helloworld.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginInputController2", urlPatterns = "/login/input2")


    public class LoginInputController2 extends HttpServlet {
        //화면 접근이기 때문에 get 으로 접근. doGet을 재정의
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //업무 -> 화면으로 전달해주는거

            //이동할 화면만 수정해주면 됨
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/WEB-INF/login/login_input2.jsp");
            dispatcher.forward(request,response);
        }
    }

