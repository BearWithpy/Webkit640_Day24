package org.webkit.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BoardServlet", value = "/board/*")
public class BoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 나는 왜 안 나올까?ㅋㅋ..
        System.out.printf("URI: %s\ncontextPath: %s\n",request.getRequestURI(), request.getContextPath() );

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter out =  response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Board</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <h1>Hello Board</h1>");
        out.println("    <h3>게시판 글 목록 페이지</h3>");
        out.println("    <hr />");
        out.println("    <p>Blah Blah~<p/>");
        out.println("  </body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
