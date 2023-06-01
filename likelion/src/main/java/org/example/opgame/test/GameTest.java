package org.example.opgame.test;

import org.example.opgame.service.OpGame;
import org.example.opgame.service.PlusOperatorLevelOne;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @Author Kim
 *
 * 1. 덧셈
 * 2. 기회 3회
 * 3. 격려
 * 4. 결과는 10 이하
 */
public class GameTest {

    @Test(testName = "OpGame 단계별 Test")
    public void test() {
        OpGame game = new OpGame(new PlusOperatorLevelOne());

        game.makeQuestion();
        String question = game.getQuestion();

        assertEquals("1 + 1 = ", question);

        assertEquals(3, game.getRemainingAnswers());

        assertEquals(false, game.isAnswer(3));

        assertEquals(2, game.getRemainingAnswers());

        assertEquals("한번 더 해 보자!", game.getCheeringUpMsg());

        assertEquals(true, game.isAnswer(2));
    }

    // tesSumMax
    @Test(testName = "두 수를 더하여 9이하가 되는지 Test")
    public void tesSumMax() {
        int max = 10;
        int inputNumOne = (int) (Math.random() * max);
        int inputNumTwo = (int) (Math.random() * (max - inputNumOne));

        System.out.printf("%d + %d = %d\n", inputNumOne, inputNumTwo, inputNumOne + inputNumTwo);

        assertTrue(inputNumOne + inputNumTwo < max);
    }

    // testRandom
    @Test(testName = "Random function")
    public void testRandom() {
        System.out.println((int) (Math.random() * 10));
    }
}
