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

        String ctxPath = request.getContextPath();
        String reqUri = request.getRequestURI();

        System.out.println("doGet() - SaramController 실행");
        System.out.printf("%s, %s\n", ctxPath, reqUri);

        int beginIndex = ctxPath.length();
        String urlPattern = reqUri.substring(beginIndex);
        System.out.println("urlPattern => " + urlPattern);

        request.setAttribute("url", urlPattern);

        // Forward to view page
        String viewName = "/WEB-INF/views/board.jsp";
        RequestDispatcher view = request.getRequestDispatcher(viewName);

        // 이 servlet 페이지에서 하는 일을 뷰 jsp로 위임
        // request와 response 객체를 전달함
        view.forward(request ,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
