package org.example.opgame.model;

import java.sql.SQLException;
import java.util.Optional;

// MemberDAO inherit BaseDAO
public class MemberDAO extends BaseDAO {

    //
    public void initMember() {
        String sql = """
                CREATE TABLE opg_member (
                                seq INTEGER PRIMARY KEY AUTOINCREMENT,
                                id TEXT NOT NULL,
                                pw TEXT NOT NULL,
                                islogined INTEGER DEFAULT '0',
                                created_at TEXT DEFAULT CURRENT_TIMESTAMP,
                                updated_at TEXT DEFAULT CURRENT_TIMESTAMP
                                )
                
                """;
        try {
            getConn();
            smt = conn.createStatement();
            smt.executeUpdate("DROP TABLE IF EXISTS opg_member");
            smt.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
    }

    public Optional<Member> login(String id, String pw) {
        String sql =  """
                update opg_member SET islogined='1' WHERE id=? and pw=?
                """;
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);
            int cnt = psmt.executeUpdate();
            if (cnt > 0) {
                psmt = conn.prepareStatement("SELECT id, islogined FROM opg_member WHERE id=?");
                psmt.setString(1, id);
                rs = psmt.executeQuery();

                if (rs.next()) {
                    String uid = rs.getString(1);
                    boolean uisLogined = rs.getBoolean(2);
                    return Optional.of(new Member(uid, uisLogined));
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
        return Optional.empty();
    }

    public int join(String id, String pw) {
        int cnt = 0;
        String sql = "insert into opg_member(id, pw) values(?, ?)";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);
            cnt = psmt.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
        return cnt;
    }


    public Optional<Member> logout(String id) {
        String sql = """
                update opg_member SET islogined='0' WHERE id=?
                """;
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, id);
            int cnt = psmt.executeUpdate();
            if (cnt > 0) {
                psmt = conn.prepareStatement("SELECT id, islogined FROM opg_member WHERE id=?");
                psmt.setString(1, id);
                rs = psmt.executeQuery();
                if (rs.next()) {
                    String rid = rs.getString(1);
                    boolean risLogined = rs.getBoolean(2);
                    return Optional.of(new Member(rid, risLogined));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
        return Optional.empty();
    }
}
