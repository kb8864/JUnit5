package sec2;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    @BeforeAll
    static void beforeAllTests(){
        System.out.println("全テストの初期化を行う");
    }

    @AfterAll
    static  void afterAllTests(){
        System.out.println("全テストの終了処理を行う");
    }

    @BeforeEach
    void setup(){
        calculator = new Calculator();
        System.out.println("テスト前に実行");
    }
    @AfterEach
    void tearDown(){
        System.out.println("テストの後処理");
    }

    void addTwoNumbers(){
        //Arrange：「登場人物（準備）」
//        Calculator calculator = new Calculator();
        System.out.println("addTwoNumbers実行");
        //Act：「行動（メソッド呼び出し）」
        int actual = calculator.add(2, 3);
        //Assert：「結果（期待通りか）」
        assertEquals(5, actual);
    }

    @Test
    void divideByZero(){
//        Calculator calculator = new Calculator();
        System.out.println("divideByZero");
        //  例外発生検証
        Exception e =  assertThrows(ArithmeticException.class,
                () -> calculator.divide(2, 0));

        assertEquals("0で割ることはできません", e.getMessage());
    }

    @Test
    void completesQuickly(){
//        Calculator calculator = new Calculator();
        System.out.println("completesQuickly");

        assertTimeout(Duration.ofMillis(100),
                () -> calculator.multiply(2, 3));
    }
    @Test
    void testWithAsswerALL(){
//        Calculator calculator = new Calculator();
        assertAll(
                () -> assertEquals(7, calculator.add(3, 4),"足し算"),
                () -> assertEquals(2, calculator.subtract(5, 3),"引き算"),
                () -> assertEquals(6, calculator.multiply(2, 3),"掛け算"),
                () -> assertEquals(5, calculator.divide(10, 2),"割り算")
        );
    }
}