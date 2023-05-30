package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMathTest {

  // TDD

  // isPrime 소수 test
  @Test
  void isPrime() {
    CMath.isPrime(3);
    CMath.isPrime(7);
    CMath.isPrime(10);
  }

  // isRepeatedPrime 소수 test
  @Test
  void isRepeatedPrime() {
    assertTrue(CMath.isRepeatedPrime(3));
    assertTrue(CMath.isRepeatedPrime(7));
    assertFalse(CMath.isRepeatedPrime(10));
  }

  // isPerpectionNumber 완전수 test
  @Test
  void isPerpectionNumber() {
    assertTrue(CMath.isPerpectionNumber(6));
    assertTrue(CMath.isPerpectionNumber(28));
    assertFalse(CMath.isPerpectionNumber(100));
  }

  // testFactors 약수 test
  @Test
  void testFactors() {
    assertEquals("[1, 2, 4, 8]", CMath.factors(16));
    assertEquals("[1, 2, 4, 5, 10, 20, 25, 50]", CMath.factors(100));
  }
}