package sec2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void addTwoNumbers(){
        //Arrange：「登場人物（準備）」
        Calculator calculator = new Calculator();
        //Act：「行動（メソッド呼び出し）」
        int actual = calculator.add(2, 3);
        //Assert：「結果（期待通りか）」
        assertEquals(5, actual);


    }

}