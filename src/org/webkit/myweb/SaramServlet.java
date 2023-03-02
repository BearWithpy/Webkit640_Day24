package org.webkit.myweb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//@WebServlet(name = "SaramServlet", value = "*.saram")

// web.xml에 servlet-mapping 해 주면 어노테이션 생략 가능.
//@WebServlet("/saram")

public class SaramServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String ctxPath = req.getContextPath();
        String reqUri = req.getRequestURI();

        int beginIndex = ctxPath.length();
        String urlPattern = reqUri.substring(beginIndex);

        req.setAttribute("userName", "홍길동");

        ArrayList<String> userList = new ArrayList<String>();
        userList.add("박준수 | 무직 | 25");
        userList.add("박길동 | 프로그래머 | 29");
        userList.add("박의진 | 의사 | 35");
        req.setAttribute("userList", userList);
        String viewName = "/WEB-INF/views/saram/list.jsp";
        RequestDispatcher view = req.getRequestDispatcher(viewName);

        view.forward(req, res);
    }
}
