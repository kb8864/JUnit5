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

    @Test
    void divideByZero(){
        Calculator calculator = new Calculator();
        //  例外発生検証
        Exception e =  assertThrows(ArithmeticException.class,
                () -> calculator.divide(2, 0));

        assertEquals("0で割ることはできません", e.getMessage());
    }
}