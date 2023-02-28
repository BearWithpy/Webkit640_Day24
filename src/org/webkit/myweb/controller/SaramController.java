package org.webkit.myweb.controller;

import org.webkit.myweb.saram.model.SaramDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SaramController implements Controller {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String path = (String) request.getAttribute("path");
        String viewName = "/WEB-INF/views/saram/list.jsp";

        if(path.indexOf("input.did") != -1){
//        if(path.contains("input.did")){
            viewName = "/WEB-INF/views/saram/input.jsp";
        }

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

        return viewName;

    }
}
