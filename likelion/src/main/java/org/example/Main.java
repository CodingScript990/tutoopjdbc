package org.example;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    checkLeapYear();
  }

  // Refactoring
  private static void checkLeapYear() {
    Scanner sc = new Scanner(System.in);

    int year = sc.nextInt();

    if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
      System.out.printf("%d O \n", year);
    } else {
      System.out.printf("%d X \n", year);
    }
  }
}