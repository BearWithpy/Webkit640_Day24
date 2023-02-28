<%@ page import="org.webkit.myweb.board.model.BoardDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: junsu
  Date: 2023/02/27
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board</title>
</head>
<body>
<h1>Is it Right??</h1>
<hr/>
<h3>May be?
    <p>
        <%
            ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) request.getAttribute("boardList");

            for (BoardDTO board : boardList) {

//        out.printf("#%f %s %s %d<br />",board.getSeq(), board.getAuthor(), board.getTitle(), board.getCnt());
//        out.println(board.getSeq()+" " + board.getAuthor()+" " +board.getTitle()+" " + board.getCnt() + "<br />");
                out.println(board + "<br />");

            }
        %>
    </p>
</h3>
</body>
</html>
