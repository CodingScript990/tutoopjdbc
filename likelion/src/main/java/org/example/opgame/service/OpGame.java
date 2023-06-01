package org.example.opgame.service;

public class OpGame {
    // Member Field
    int inputNumOne, inputNumTwo; // 출제 값1,2
    int remainingAnswers; // 3번의 기회제공
    String cheeringUpMsg = "한번 더 해보자!"; // message
    IOperator op; // interface value

    //
    public OpGame(IOperator op) {
        this.op = op;
    }

    // 기회제공 메서드
    public void makeQuestion() {
        remainingAnswers = 3; // 3번의 기회 제공

        //inputNumOne = 1; // 출제 값1
        //inputNumTwo = 1; // 출제 값2
        op.setA(1); // 값1를 담아주는 역할
        op.setB(1); // 값2를 담아주는 역할
    }

    // 랜덤 메서드
    public void makeQuestion(int max) {
        //inputNumOne = (int) (Math.random() * max); // 출제 값1
        //inputNumTwo = (int) (Math.random() * (max - inputNumOne)); // 출제 값2
        op.generateQuestion(max); // max 값이 반환되도록 함
    }

    // 문제 메서드
    public String getQuestion() {
        //return String.format("%d + %d = ", inputNumOne, inputNumTwo);
        return op.getQuestionMsg(); // message 값이 반환되도록 함
    }

    // 답을 물어보는 메서드
    public int getRemainingAnswers() {
        return remainingAnswers;
    }

    // 정답이 아닐 시 기회를 감소시키는 메서드
    public boolean isAnswer(int answer) {
        remainingAnswers--;
        // return (inputNumOne + inputNumTwo) == answer;
        return op.isEquals(answer); // 값을 비교하고 반환함
    }

    // 정답이 아닐 시 격려의 메세지를 남겨주는 메서드
    public String getCheeringUpMsg() {
        return cheeringUpMsg;
    }
}
