package com.busanit501.helloworld.calc;

//입력화면 접근은, jsp 파일에 직접 접근 안하고
//http://localhost:8080/calc/input-> 서블릿에 접근
//서블릿(자바파일)-> 뷰화면(jsp파일)로 전달해줌.
//결론 , 웹브라우저 입장에서 입력화면 도착

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//입력화면에서 , 폼 -> action -> 서버에 전달하는 주소를 서블릿 url 주소로변경,
//변경 전 : 결과 화면 페이지에 직접 접근
//변경 후 : 서블릿(자바파일) 경유해서, 결과화면으로 이동함.
@WebServlet(name = "calcResultController", urlPatterns = "/calc/result")
public class CalcResultController extends HttpServlet {
    @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        System.out.println("num1 : " + num1 + ", num2 : " + num2);
    }

}
