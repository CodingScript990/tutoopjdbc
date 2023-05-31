package org.example.db;

import org.example.model.BaseDAO;
import org.example.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// BaseDAO 상속 받아 Connection 기능을 사용함
public class DBMain extends BaseDAO {
    public static void main(String[] args) {

        DBMain dbMain = new DBMain(); // 인스턴스화

        dbMain.initPerson(); // 초기화 단계(인스턴스 객체로 호출)

        System.out.println(dbMain.insertPerson("leo"));
        System.out.println(dbMain.insertPerson("yui"));

        List<Person> personList = dbMain.findAllPerson();

        System.out.println(personList.toString());
        System.out.println(dbMain.findByNamePerson("bab"));
        System.out.println(dbMain.findByNameOptionalPerson("bab"));

    }

    // findByNameOptionalPerson method => Refactoring
    private Optional<Person> findByNameOptionalPerson(String pName) {

        String sql = "select id, name from person where name = ?";

        try {
            getConn();
            psmt = conn.prepareStatement(sql); // sql문 실행
            psmt.setString(1, pName); // sql 문에서 data
            rs = psmt.executeQuery(); // 결과를 실행

            if (rs.next()) {
                // get int => id
                int id = rs.getInt("id");
                // get String => name
                String name = rs.getString("name");
                // Optional.of Type 으로 변경
                return Optional.of(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        // Optional.empty() 를 반환함
        return Optional.empty();
    }

    // findByNamePerson method => Refactoring
    private Person findByNamePerson(String pName) {

        String sql = "select id, name from person where name = ?";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, pName);
            rs = psmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                return new Person(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        // null 를 반환함
        return null;
    }

    // findAllPerson method => Refactoring
    private List<Person> findAllPerson() {
        List<Person> result = new ArrayList<>();

        String sql = "select id, name from person";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new Person(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        // result 를 반환함
        return result;
    }

    // initPerson method => Refactoring
    private int insertPerson(String name) {
        int cnt = 0;
        String sql = "insert into person(name) values(?)";
        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, name);
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


    // initPerson method => Refactoring
    private void initPerson() {
        String sql = """
                create table person (
                id integer primary key autoincrement,
                name string
                )
                """;
        try {
            getConn();
            smt = conn.createStatement();
            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close();
        }
    }

    // getCodeName method => Refactoring
    private void gatCodeName() {
        String sql = "select code, name from country order by code, name";

        try {
            getConn();
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                System.out.print( rs.getString("code") + "\t");
                System.out.println( rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
