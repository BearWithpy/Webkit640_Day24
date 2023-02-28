package org.webkit.myweb;

import org.webkit.myweb.board.model.BoardDTO;
import org.webkit.myweb.controller.BoardController;
import org.webkit.myweb.controller.SaramController;
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

        BoardController bc = new BoardController();
        SaramController sc = new SaramController();
        String viewName = "";

        String uri = request.getRequestURI();
//        String action = uri.substring(uri.lastIndexOf("/") + 1);
//        System.out.println("URI : " + uri);
//        System.out.println("ACTION : " + action);

        if ("/saram/list.did".equals(uri)) {
            viewName = sc.process(request, response);
            forwardView(request, response, viewName);

        } else if ("/board/list.did".equals(uri)) {
            viewName = bc.process(request, response);
            forwardView(request, response, viewName);
        }
    }

    protected void forwardView(HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
