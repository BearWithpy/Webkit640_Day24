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

//        System.out.println("doGet() - SaramController 실행");
//        System.out.printf("%s, %s\n", ctxPath, reqUri);

        int beginIndex = ctxPath.length();
        String urlPattern = reqUri.substring(beginIndex);
//        System.out.println("urlPattern => " + urlPattern);

        // view 페이지에서 사용될 변수 request에 저장.
        // forward 될때 request도 전달.
        // JSP 페이지에서 request.getArribute("username");으로 사용.
        // ${username} EL 문법
        req.setAttribute("userName", "홍길동");

        ArrayList<String> userList = new ArrayList<String>();
        userList.add("박준수 | 무직 | 25");
        userList.add("박길동 | 프로그래머 | 29");
        userList.add("박의진 | 의사 | 35");
        req.setAttribute("userList", userList);
        // JSP에서는 request.getAttribute("userList"); 사용.


        // view 페이지로 forward 하기
        // RequestDispatcher 객체를 이용한 view 페이지 forward
        // Forward to view page
        String viewName = "/WEB-INF/views/saram/list.jsp";
        RequestDispatcher view = req.getRequestDispatcher(viewName);

        // 이 servlet 페이지에서 하는 일을 뷰 jsp로 위임
        // request와 response 객체를 전달함
        view.forward(req, res);
    }
}
