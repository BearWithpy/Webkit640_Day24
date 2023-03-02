<%@ page import="java.sql.Connection" %>
<%@ page import="org.webkit.myweb.dbcp.JdbcUtil" %><%--
  Created by IntelliJ IDEA.
  User: junsu
  Date: 2023/02/28
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connect Test</title>
</head>
<body>
<%
    Connection conn = JdbcUtil.getConnection();
    out.println(conn);

    JdbcUtil.close(conn);


%>

</body>
</html>
