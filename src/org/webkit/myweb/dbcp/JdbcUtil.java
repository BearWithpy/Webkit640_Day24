package org.webkit.myweb.dbcp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

// https://web2eye.tistory.com/36
public class JdbcUtil {

    public static Connection getConnection() throws NamingException, SQLException {

        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource)
                envCtx.lookup("jdbc/H2DB");
        return ds.getConnection();
    }

    public static void close(Connection obj) {
        try {
            if (obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet obj) {
        try {
            if (obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement obj) {
        try {
            if (obj != null) obj.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
        close(conn);
    }
}
