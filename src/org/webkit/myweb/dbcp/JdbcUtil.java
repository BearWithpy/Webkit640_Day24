package org.webkit.myweb.dbcp;

import java.sql.*;

// https://web2eye.tistory.com/36
public class JdbcUtil {

    public static Connection getConnection() {
        // JDBC 연동 - 커넥션 드라이버 찾기

        Connection conn = null;
        try {
            Class.forName("org.h2.Driver"); // 드라이버 검색 -> 인스턴스화
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 검색 실패!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 오류!");
            e.printStackTrace();
        }
        return conn;
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
