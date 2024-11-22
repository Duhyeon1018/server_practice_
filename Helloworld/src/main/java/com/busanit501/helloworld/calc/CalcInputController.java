package com.busanit501.helloworld.calc;

//서블릿 = 컨트롤러 역할 (서블릿은 자바에서함0
//웹 브라우저로부터 들어온 요청에 대해서
//화면을 제공 또는 데이터를 전달하는 중간 정류장 역할(관제탑 역할)

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalcInputController", urlPatterns = "/calc/input")
//웹 브라우저에서 주소를 :http://localhost:8080/calc/input 입력하면
//이 파일(클래스)가 응답 -> 입력 화면으로 전달 해주는 역할
//그래ㅓ 앞에 화면에 직접 접근하는게 아니라 서블릿을 통해서 접근을 함.

public class CalcInputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) {

    }
}


