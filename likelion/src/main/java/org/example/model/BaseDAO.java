package org.example.model;

import java.sql.*;

// 반복적인 파트를 따로 빼서 상속해서 사용해주는 작업
public class BaseDAO {
    // 접근제어자(protected)로 상속받게 해줌
    protected Connection conn = null;
    protected Statement smt = null;
    protected PreparedStatement psmt = null;
    protected ResultSet rs = null;

    // getConn method => DB Connection
    protected void getConn() {

        String url = "jdbc:sqlite:world.db";
        String userId = "";
        String userPassword = "";

        try {
            // Connection Info 만 빼면됨
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // close method => try-catch(예외처리)
    protected void close() {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (smt != null) smt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (psmt != null) psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
