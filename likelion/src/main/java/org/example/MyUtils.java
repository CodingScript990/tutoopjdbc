package org.example;

import java.io.PrintStream;

public class MyUtils {
  // Refactoring

  // game369Ex method
  public static void game369Ex() {
    int cnt = 333;

    String result = isGame369(cnt);
    System.out.printf("%d%s\n", cnt, result);
  }

  // game369 method
  public static void game369() {
    for (int cnt = 0; cnt < 100; cnt++) {
      System.out.print(cnt + "");

      int tenNum = cnt / 10; // 십의 자리
      int oneNum = cnt % 10; // 일의 자리

      if (tenNum % 3 == 0 && tenNum != 0) System.out.print("*");
      if (oneNum % 3 == 0 && oneNum != 0) System.out.print("*");

      System.out.println();
    }
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

  // isGame369 method => 재귀호출
  public static String isGame369(int cnt) {

    int tenNum = cnt / 10; // 십의 자리
    int oneNum = cnt % 10; // 일의 자리

    String result = (oneNum % 3 == 0 && oneNum != 0) ? "*" : "";

    if (tenNum == 0) return result;

    return result + isGame369(tenNum);
  }
}
