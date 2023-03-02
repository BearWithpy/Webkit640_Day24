<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="org.webkit.myweb.saram.model.SaramDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="org.webkit.myweb.saram.model.SaramDTO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintStream" %><%--
  Created by IntelliJ IDEA.
  User: junsu
  Date: 2023/03/02
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JNDI</title>
</head>
<body>
<%!
    SaramDAO saramDao = new SaramDAO();

    public void testFindAll(javax.servlet.jsp.JspWriter out) throws IOException {
        List<SaramDTO> list = saramDao.findAll();
        out.println(list);
    }

%>

<%
    SaramDTO dto = new SaramDTO(0, "KANG2","강감찬2",25);
    saramDao.save(dto);

// 삭제 테스트
    dto.setSeq(5);
    saramDao.deleteOne(dto);

    testFindAll(out);
%>

</body>
</html>
