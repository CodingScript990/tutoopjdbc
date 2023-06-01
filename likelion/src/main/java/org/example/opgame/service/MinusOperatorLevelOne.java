package org.example.opgame.service;

// IOperator interface 를 상속 받아줌
//// 새로운 - 게임을 만들고 OpGame Class 에서 요구하는 방식만 넣어주도록 해주기 위함
public class MinusOperatorLevelOne implements IOperator{
    // Member Field
    int inputNumOne, inputNumTwo; // 출제 값1,2
    @Override
    public void setA(int inputNumOne) {

    }

    @Override
    public void setB(int inputNumTwo) {

    }

    @Override
    public void generateQuestion(int max) {
        inputNumOne = (int) (Math.random() * max);
        inputNumTwo = (int) (Math.random() * max);

        if (inputNumOne < inputNumTwo) {
            int temp = inputNumOne;
            inputNumOne = inputNumTwo;
            inputNumTwo = temp;
        }
    }

    @Override
    public String getQuestionMsg() {
        return String.format("%d - %d = ", inputNumOne, inputNumTwo);
    }

    @Override
    public boolean isEquals(int answer) {
        return (inputNumOne - inputNumTwo) == answer;
    }
}
