package exercises;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

class SimpleCalculatorTest {
    SimpleCalculator calculator = new SimpleCalculator();

    @DisplayName("add(3, 5) の結果は 8 ")
    @Test
    void testAdd(){
        assertEquals(8, calculator.add(3, 5));
    }

    @DisplayName(" subtract(10, 4) の結果 6")
    @Test
    void testSubtract(){
    int result = calculator.subtract(10, 4);
    assertEquals(6, result);

    }

    @DisplayName( "multiply(4, 6) の結果24")
    @Test
    void testMultiply(){
        int result = calculator.multiply(4,6 );
        assertEquals(24, result);
    }

    @DisplayName("divide(20, 5) の結果 4")
    @Test
    void testDivide(){
        int result = calculator.divide(20, 5);
        assertEquals(4 , result);
    }

    @DisplayName("divide(10, 0) を呼び出すと ArithmeticException がスローされる")
    @Test
    void testDivideByZero(){
    assertThrows(ArithmeticException.class, () ->calculator.divide(10, 0));
    }

    @DisplayName("テストが成功したらlongProcess() メソッドが 100ミリ秒以内 に完了")
    @Test
//    「中の処理がこの時間内に終わるか」を確認するのはassertTimeout
    void testLongProcessWithinTime(){
        assertTimeout(Duration.ofMillis(100), ()->calculator.longProcess());
    }

}