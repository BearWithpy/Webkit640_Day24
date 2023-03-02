
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.webkit.myweb.saram.model.SaramDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- JSP 지시어 -->
<!-- JSP 선언문 : 자바 Class의 멤버 필드, 멤버 메서드 선언하는 부분이다. -->
<%!
    // JSP 선언문 : 이곳에는 멤버필드(전역변수)와 멤버메서드(전역함수)를 선언 할 수 있다.
    private String username = "김범준";

    public String hello() {
        return "Hello " + username + " world";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Saram List</title>
</head>
<body>

<h3>Junsu in the LAB</h3>
<h1>사람 목록</h1>

<!-- EL 표기법 -->
<p>${saram}</p>
<%
    // 스크립트 릿 - _jspService() 함수의 내용.
// 스크립트 릿은 함수의 내용이므로 함수나 필드 선언 불가능.
    out.println("<h2>" + hello() + "</h2>");
%>

<%
    ArrayList<SaramDTO> list = (ArrayList<SaramDTO>) request.getAttribute("userList");
    for (SaramDTO saram : list) {
%>
<p><a href="modify.did?seq=<%=saram.getSeq()%>"><%=saram %>
</a></p>
<%
    }
%>
<p><a href="input.did">사람등록</a></p>
</body>
</html>