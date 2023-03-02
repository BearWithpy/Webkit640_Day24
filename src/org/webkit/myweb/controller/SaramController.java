package org.webkit.myweb.controller;

import org.webkit.myweb.saram.model.SaramDAO;
import org.webkit.myweb.saram.model.SaramDTO;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaramController implements Controller {


    @Override
    public String process(HttpServletRequest req, HttpServletResponse resp) throws SQLException, NamingException {
        // String으로 다운 캐스팅
        String path = (String) req.getAttribute("path");

        // SaramDTO 객체(Bean)가 저장된 List를 view 페이지에 전달 하기.
//        SaramDTO saram = new SaramDTO(1, "hong", "홍길동", 25);//
//        req.setAttribute("saram", saram);

        SaramDAO dao = new SaramDAO();
        String viewName = "/WEB-INF/views/index.jsp";
        if (path.contains("/input.did")) {
            viewName = "/WEB-INF/views/saram/input.jsp";
        } else if (path.contains("/detail.did")) {
            viewName = "/WEB-INF/views/saram/detail.jsp";
        } else if (path.contains("/modify.did")) {
            SaramDTO dto = new SaramDTO();
            // 링크에서 쿼리스트링으로 전달 된 seq 값을 받아서 검색한다.
            dto.setSeq(Integer.parseInt(req.getParameter("seq") ) );
            SaramDTO saram = dao.findOne(dto);
            req.setAttribute("saram", saram);
            viewName = "/WEB-INF/views/saram/modify.jsp";
        } else {
            List<SaramDTO> list = dao.findAll();
            req.setAttribute("userList", list);
            viewName = "/WEB-INF/views/saram/list.jsp";
        }
        return viewName;

    }


}
