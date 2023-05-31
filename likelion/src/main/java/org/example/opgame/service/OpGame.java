package org.example.opgame.service;

public class OpGame {
    // Member Field
    int inputNumOne, inputNumTwo; // 출제 값1,2
    int remainingAnswers; // 3번의 기회제공

    //
    public void makeQuestion() {
        remainingAnswers = 3; // 3번의 기회 제공

        inputNumOne = 1; // 출제 값1
        inputNumTwo = 1; // 출제 값2
    }

    // 문제 메서드
    public String getQuestion() {
        return String.format("%d + %d = ", inputNumOne, inputNumTwo);
    }

    // 답을 물어보는 메서드
    public int getRemainingAnswers() {
        return remainingAnswers;
    }

    // 정답이 아닐 시 기회를 감소시키는 메서드
    public boolean isAnswer(int answer) {
        remainingAnswers--;
        return (inputNumOne + inputNumTwo) == answer;
    }

    // 정답이 아닐 시 격려의 메세지를 남겨주는 메서드
    public String getCheeringUpMsg() {
        return "한번 더 해 보자!";
    }
}
