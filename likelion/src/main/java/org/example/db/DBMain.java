package org.example.db;

import java.sql.*;

public class DBMain {
    public static void main(String[] args) {

        initPerson(); // 초기화 단계
    }

    // initPerson method => Refactoring
    private static void initPerson() {
        Connection conn = null;
        Statement smt = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            // create a database connection
            conn = DriverManager.getConnection("jdbc:sqlite:world.db");
            smt = conn.createStatement();
            smt.setQueryTimeout(30);  // set timeout to 30 sec.

            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate("create table person (id integer, name string)");
            smt.executeUpdate("insert into person values(1, 'leo')");
            smt.executeUpdate("insert into person values(2, 'yui')");
            rs = smt.executeQuery("select * from person");
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    private static void gatCodeName() throws SQLException {
        String sql = "select code, name from country order by code, name";
        Connection conn = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;
        try {
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("result"));
                System.out.print(rs.getString("code") + "\t");
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
