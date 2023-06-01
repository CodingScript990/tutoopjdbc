package org.example.opgame.service;

public interface IOperator {
    void setA(int inputNumOne); // inputNumOne 값을 받아주는 역할

    void setB(int inputNumTwo); // inputNumTwo 값을 받아주는 역할

    void generateQuestion(int max); // max 값을 받아주는 역할

    String getQuestionMsg(); // message 를 보여주는 역할

    boolean isEquals(int answer); // 값을 비교해주는 역할
}
