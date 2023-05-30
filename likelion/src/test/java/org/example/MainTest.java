package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  // TDD

  // checkLeapYear test
  @Test
  void checkLeapYear() {
    assertEquals(true, Main.checkLeapYear(1700)); // output => true, false
  }

  // printYear test
  @Test
  void printYear() {
    assertEquals(true, Main.printYear(2020)); // output value
  }

  // testLeapYear test
  @Test
  void testLeapYear() {
    // is를 붙이는건 boolean 을 말함
    assertEquals(true, Main.isLeapYear(2020)); // 4로 나눈 후 윤년 값
    assertEquals(false, Main.isLeapYear(1900)); // 100로 나눈 후 윤년 값
    assertEquals(true, Main.isLeapYear(2400)); // 400로 나눈 후 윤년 값
  }

  // gameTest369 test
  @Test
  void gameTest369() {
    // 재귀호출
    assertEquals("*", Main.isGame369(3)); // 3,6,9 한 자리
    assertEquals("", Main.isGame369(15)); // 해당 안될 시
    assertEquals("**", Main.isGame369(33)); // 33 십의 자리
    assertEquals("***", Main.isGame369(333)); // 333 백의 자리
    assertEquals("****", Main.isGame369(3369)); // 3369 천의 자리
  }
}