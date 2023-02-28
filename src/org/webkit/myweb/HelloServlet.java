package org.webkit.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// 어노테이션 사용하면 되지만 일단 web.xml에 정의해 두었음..
//@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    // Servlet 실행 시키는 방법 = web.xml에 매칭시킨 주소를 브라우저 주소창에 입력
    // 브라우저를 통해서만 실행해야 함
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("/hello - doGet() 실행됨");

        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        // req 객체이 요청 정보(session, uri, parameter..)를 저장함
        // res 객체에는 브라우저에서 처리하는 정보(forward, redirect 정보...)가 저장된다
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Hello world</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <h1>Hello world</h1>");
        out.println("    <p><a href=\"http://naver.com\">네이버로 이동</p>");
        out.println("  </body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
