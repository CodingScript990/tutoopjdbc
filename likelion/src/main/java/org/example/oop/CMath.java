package org.example.oop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CMath {
  // 약수 구하기, 소수 구하기, 완전수 구하기

  // 3,7,10

  // isPrime method => 소수 구하기
  public static boolean isPrime(int cnt) {

    boolean result = false;

    if (cnt % 3 == 0 || cnt % 7 == 0) {
      System.out.printf("%d -> %b\n", cnt, !result);
      return !result;
    }
    System.out.printf("%d -> %b\n", cnt, result);
    return result;
  }

  // isRepeatedPrime method => 소수 구하기
  public static boolean isRepeatedPrime(int cnt) {

    boolean result = false;

    int count = factorsOf(cnt).size();

    System.out.printf("%d -> %b\n", cnt, result);


    return (count == 1);

  }

  // isPerpectionNumber method => 완전수
  public static boolean isPerpectionNumber(int cnt) {

    List<Integer> numbers = factorsOf(cnt);

    boolean result = false;

    int sum = numbers.stream().mapToInt(Integer::intValue).sum();
    System.out.printf("%d -> %b\n", cnt, result);

    return (sum == cnt);
    // 합계가 cnt 와 같으면 true
  }

  // factors method => string type
  public static String factors(int cnt) {
      return factorsOf(cnt).toString();
  }

  // factorsOf method => 약수 구하기
  private static List<Integer> factorsOf(int cnt) {

    List<Integer> numbers = new ArrayList<>();

    for (int i = 1; i < cnt; i++) {
      if (cnt % i == 0) numbers.add(i);
    }
    System.out.printf("%d -> %s\n", cnt, numbers);

    return numbers;
  }
}
