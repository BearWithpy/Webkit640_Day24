package org.webkit.myweb;

import org.webkit.myweb.board.model.BoardDTO;
import org.webkit.myweb.controller.BoardController;
import org.webkit.myweb.controller.Controller;
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
//@WebServlet(name = "DispatcherServlet", urlPatterns = {"/saram/list.did", "/board/list.did"})
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller = null;
        String viewName = "";
        String uri = request.getRequestURI();

        request.setAttribute("path", uri);

//        String action = uri.substring(uri.lastIndexOf("/") + 1);
        String category = uri.substring(0, uri.lastIndexOf("/"));
        System.out.println("URI : " + uri);
        System.out.println("category : " + category);

        if ("/board".equals(category)) {
            controller = new BoardController();
            viewName = controller.process(request, response);
            forwardView(request, response, viewName);

        } else if ("/saram".equals(category)) {
            controller = new SaramController();
            viewName = controller.process(request, response);
            forwardView(request, response, viewName);
        }
    }

    protected void forwardView(HttpServletRequest request, HttpServletResponse response, String viewName) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller;
        String viewName;
        String uri = request.getRequestURI();

        request.setAttribute("path", uri);


        String action = uri.substring(0, uri.lastIndexOf("/"));
        System.out.println("URI : " + uri);
        System.out.println("POST ACTION : " + action);

        String id = request.getParameter("id");
        String name = request.getParameter("id");
        int age = Integer.parseInt(request.getParameter("age") == null ? "0" : request.getParameter("age"));

        SaramDTO dto = new SaramDTO(99,name,id,age);
        System.out.println(dto);
        response.sendRedirect("/");


//        if ("/board".equals(action)) {
//            controller = new BoardController();
//            viewName = controller.process(request, response);
//            forwardView(request, response, viewName);
//
//        } else if ("/saram".equals(action)) {
//            controller = new SaramController();
//            viewName = controller.process(request, response);
//            forwardView(request, response, viewName);
//        }
    }
}
