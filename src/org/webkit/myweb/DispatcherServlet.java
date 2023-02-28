package org.webkit.myweb;

import org.webkit.myweb.board.model.BoardDTO;
import org.webkit.myweb.saram.model.SaramDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


//@WebFilter(urlPatterns="*.did")
//@WebServlet(name = "DispatcherServlet")
//@WebServlet("/test/*.did")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String ctxPath = request.getContextPath();
//        String reqUri = request.getRequestURI();
//
//        int beginIndex = ctxPath.length();
//        String urlPattern = reqUri.substring(beginIndex);

        System.out.println(".did doGet()");

        String uri = request.getRequestURI();
        String action = uri.substring(uri.lastIndexOf("/") + 1);

        System.out.println("URI : " + uri);
        System.out.println("ACTION : " + action);


        // Action별로 로직
        if ("/saram/list.did".equals(uri)) {
            System.out.println("saram");
            testSaramService(request, response);
//            view.forward(request, response);
        } else if ("/board/list.did".equals(uri)) {
            System.out.println("board");
            testBoardService(request, response);
//            view.forward(request, response);
        }
    }

    protected void testSaramService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = "/WEB-INF/views/saram/list.jsp";

        SaramDTO saram1 = new SaramDTO(1, "박준수", "pjs", 25);
        SaramDTO saram2 = new SaramDTO(2, "박00", "js", 15);
        SaramDTO saram3 = new SaramDTO(3, "박xx", "ps", 35);
        SaramDTO saram4 = new SaramDTO(4, "박33", "pj", 24);

        ArrayList<SaramDTO> userList = new ArrayList<>();
        userList.add(saram1);
        userList.add(saram2);
        userList.add(saram3);
        userList.add(saram4);
        request.setAttribute("userList", userList);

        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }

    protected void testBoardService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewName = "/WEB-INF/views/board/list.jsp";
        BoardDTO board1 = new BoardDTO(1L, 24L, "제목", "이게 무슨 일이야?ㅋ", "박준수", new Date());

        ArrayList<BoardDTO> boardList = new ArrayList<>();
        boardList.add(board1);
        request.setAttribute("boardList", boardList);

        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
