package org.example.opgame.test;

import org.example.opgame.model.Member;
import org.example.opgame.model.MemberDAO;
import java.util.Optional;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class DAOTest {

    // testLoginAndLogout
    @Test(testName = "Login, Logout Test")
    public void testLoginAndLogout() {

        // user id, pw => info
        String id = "leo";
        String pw = "1234";

        MemberDAO dao = new MemberDAO(); // MemberDAO 인스턴스화
        dao.initMember(); // testing을 위한 작업(초기 셋팅)
        Optional<Member> user = dao.login(id, pw); // user id, pw 값이 있으면 로그인함

        // user의 값이 존재하는가?
        if(user.isEmpty()) {
            dao.join(id, pw); // 회원가입하게 만듬
            user = dao.login(id, pw); // 로그인하게 만듬
        }

        // user id값과 DB id value 값 비교하고 동일하면 진행!
        assertEquals(id, user.get().getID());
        assertTrue(user.get().isLogined());

        // user value(id) 대입
        user = dao.logout(id);

        // user login 값 비교
        assertFalse(user.get().isLogined());
    }
}
