<%@ page import="java.util.ArrayList" %>
<%@ page import="org.webkit.myweb.saram.model.SaramDTO" %><%--
  Created by IntelliJ IDEA.
  User: junsu
  Date: 2023/02/27
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>사람 목록 페이지</h1>
<%--    <p>관리자:  ${userName}</p>--%>
<p>
    <%
        ArrayList<SaramDTO> userList = (ArrayList<SaramDTO>) request.getAttribute("userList");

        for (SaramDTO user : userList) {
//                out.printf("#%d %s %s %d\n",user.id, user.name, user.nickname, user.age);
            out.println(user + "<br />");
//                out.println(user.name + "<br />");
        }
    %>
</p>
<a href="input.did">사람 정보 input</a>
</body>
</html>

<%--JSP ---> Servlet(.java) ---- 컴파일 후 tomcat에서 .class로 실행 ==> html 소스가 client에 전달됨 --%>

<%--Model - dao dto, // db와 관련있는 부분--%>
<%--View - jsp, ajax, Thymeleaf, //사용자가 보는 화면과 연관되는 부분--%>
<%--Controller - servlet, // 모델1에서는 jsp가 컨트롤러 역할을 하게 된다고 볼 수 있음(controller + model)--%>