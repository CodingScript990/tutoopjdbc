package org.example;

import java.io.PrintStream;

public class Main {
  public static void main(String[] args) {

    // 인스턴스화 참조타입[Main] / 참조변수[main]
    Main main = new Main();

    // printYear => input value test
    main.printYear(1700);
  }

  // Refactoring
  // checkLeapYear method
  public static boolean checkLeapYear(int year) {
    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
  }

  // printYear method
  public static PrintStream printYear(int year) {
    return checkLeapYear(year) ? System.out.printf("%d O\n", year) : System.out.printf("%d X\n", year);
  }

  // isLeapYear method
  public static boolean isLeapYear(int year) {

    if (year % 400 == 0) return true; // 400로 나눈 윤년 값은 false
    if (year % 100 == 0) return false; // 100로 나눈 윤년 값은 false
    if (year % 4 == 0) return true; // 4로 나눈 윤년 값은 true


    return false;
  }
}