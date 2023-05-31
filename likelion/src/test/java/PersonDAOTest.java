import org.example.model.PersonDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonDAOTest {
    PersonDAO personDAO = new PersonDAO(); // 인스턴스화

    // 초기화 작업
    @BeforeEach
    void setUp() {
        personDAO.initPerson();
    }

    @Test
    void findByNameOptionalPerson() {
        String name = "leo";
        personDAO.insertPerson(name);
        assertEquals(name, personDAO.findByNamePerson(name).getName());
        assertEquals(name, personDAO.findByNamePerson("aa"));
        assertEquals(Optional.empty(), personDAO.findByNameOptionalPerson("aa"));
    }

    @Test
    void findAllPerson() {
        personDAO.insertPerson("leo");
        personDAO.insertPerson("yui");
        assertEquals("[001 leo, 002 yui]", personDAO.findAllPerson().toString());

    }

    @Test
    void insertPerson() {
        int cnt = personDAO.insertPerson("leo");
        assertEquals(1, cnt);
    }
}