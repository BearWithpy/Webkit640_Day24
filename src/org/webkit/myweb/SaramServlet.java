package org.webkit.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "SaramServlet", value = "/SaramServlet")
public class SaramServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=utf-8");

        String ctxPath = req.getContextPath();
        String reqUri = req.getRequestURI();

        System.out.println("doGet() - SaramController 실행");
        System.out.printf("%s, %s\n", ctxPath, reqUri);

        int beginIndex = ctxPath.length();
        String urlPattern = reqUri.substring(beginIndex);
        System.out.println("urlPattern => " + urlPattern);

        PrintWriter out =  res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>Saram</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("    <h1>Hello Saram</h1>");
        out.println("    <h3>사람 목록 페이지</h3>");
        out.println("    <hr />");
        out.println("  </body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    }
}
