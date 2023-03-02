package org.webkit.myweb.controller;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public interface Controller {
    String process(HttpServletRequest request, HttpServletResponse response) throws SQLException, NamingException;
}
