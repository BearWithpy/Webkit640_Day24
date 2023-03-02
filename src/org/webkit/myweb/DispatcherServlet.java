package org.webkit.myweb;

import org.webkit.myweb.controller.BoardController;
import org.webkit.myweb.controller.Controller;
import org.webkit.myweb.controller.SaramController;
import org.webkit.myweb.saram.model.SaramDAO;
import org.webkit.myweb.saram.model.SaramDTO;

import javax.naming.NamingException;
import javax.servlet.*;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;


//@WebFilter(urlPatterns="*.did")
//@WebServlet(name = "DispatcherServlet")
//@WebServlet(name = "DispatcherServlet", urlPatterns = {"/saram/list.did", "/board/list.did"})
public class DispatcherServlet extends HttpServlet {

    private String encodeWork(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // path 만들기
        String ctxPath = request.getContextPath();
        String reqUri = request.getRequestURI();
        int beginIndex = ctxPath.length();
        String path = reqUri.substring(beginIndex);
        System.out.println("path >>>> " + path);

        request.setAttribute("path", path);
        return path;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller = null;
        String viewName = "";
        String path = encodeWork(request, response);

        if (path.contains("/saram")) {
            controller = new SaramController();
        } else if (path.contains("/board")) {
            controller = new BoardController();
        }
        assert controller != null;
        try {
            viewName = controller.process(request, response);
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher view = request.getRequestDispatcher(viewName);
        view.forward(request, response);
    }

    SaramDAO saramDAO = new SaramDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Controller controller;
        String viewName;

        String path = encodeWork(request, response);

        int seq = Integer.parseInt(request.getParameter("seq")==null?"0":request.getParameter("seq"));
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age")==null?"0":request.getParameter("age"));
        SaramDTO dto = new SaramDTO(seq, id, name, age);
        if("/saram/input.did".contains(path)) {
            saramDAO.save(dto);
        } else if("/saram/modify.did".contains(path)) {
            saramDAO.update(dto);
        }
        response.sendRedirect(request.getContextPath() + "/saram/list.did");

    }
}
