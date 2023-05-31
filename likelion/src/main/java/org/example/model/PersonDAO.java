package org.example.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDAO extends BaseDAO{
    // findByNameOptionalPerson method => Refactoring
    public Optional<Person> findByNameOptionalPerson(String pName) {

        String sql = "select id, name from person where name = ?"; // Query문

        try {
            getConn();
            psmt = conn.prepareStatement(sql); // sql문 실행
            psmt.setString(1, pName); // sql 문에서 원하는 data의 값을 불러옴
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
    public Person findByNamePerson(String pName) {

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
    public List<Person> findAllPerson() {
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
    public int insertPerson(String name) {
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
    public void initPerson() {
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
}
