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
}