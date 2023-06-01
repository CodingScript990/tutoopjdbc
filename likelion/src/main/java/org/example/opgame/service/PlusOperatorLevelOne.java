package org.example.opgame.service;

// IOperator interface 를 상속 받아줌
// 새로운 + 게임을 만들고 OpGame Class 에서 요구하는 방식만 넣어주도록 해주기 위함
public class PlusOperatorLevelOne implements IOperator{
    @Override
    public void setA(int inputNumOne) {
        
    }

    @Override
    public void setB(int inputNumTwo) {

    }

    @Override
    public void generateQuestion(int max) {

    }

    @Override
    public String getQuestionMsg() {
        return null;
    }

    @Override
    public boolean isEquals(int answer) {
        return false;
    }
}
