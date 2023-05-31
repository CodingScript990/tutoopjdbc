package org.example.db;

import org.example.model.BaseDAO;
import org.example.model.Person;
import org.example.model.PersonDAO;

import java.util.List;

// BaseDAO 상속 받아 Connection 기능을 사용함
public class DBMain extends BaseDAO {
    public static void main(String[] args) {

        PersonDAO personDAO = new PersonDAO(); // 인스턴스화

        personDAO.initPerson(); // 초기화 단계(인스턴스 객체로 호출)

        System.out.println(personDAO.insertPerson("leo"));
        System.out.println(personDAO.insertPerson("yui"));

        List<Person> personList = personDAO.findAllPerson();

        System.out.println(personList.toString());
        System.out.println(personDAO.findByNamePerson("bab"));
        System.out.println(personDAO.findByNameOptionalPerson("bab"));

    }
}
