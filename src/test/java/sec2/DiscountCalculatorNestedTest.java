package sec2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorNestedTest {
    private  final  DiscountCalculator calculator = new DiscountCalculator();

    @Nested
    @DisplayName("割引なし（0円〜4999円）のテスト")
    class  NoDiscountTests{

        @Test
        @DisplayName(("金額0円：割引なし"))
         void testAmount0() {
             assertEquals(0.0, calculator.calculateDiscount(0));
         }

        @Test
        @DisplayName("金額4999円：割引なし（上限境界）")
        void testAmount4999() {
            assertEquals(0.0, calculator.calculateDiscount(4999));
        }
    }
    @Nested
    @DisplayName("5%割引（5000〜9999円）のテスト")
    class FivePercentDiscountTests {

        @Test
        @DisplayName("金額5000円：5%割引（下限）")
        void testAmount5000() {
            assertEquals(250.0, calculator.calculateDiscount(5000));
        }

        @Test
        @DisplayName("金額9999円：5%割引（上限）")
        void testAmount9999() {
            assertEquals(499.95, calculator.calculateDiscount(9999), 0.01);
        }
    }

    @Nested
    @DisplayName("10%割引（10000円以上）のテスト")
    class TenPercentDiscountTests {

        @Test
        @DisplayName("金額10000円：10%割引（下限）")
        void testAmount10000() {
            assertEquals(1000.0, calculator.calculateDiscount(10000));
        }
    }


    @Nested
    @DisplayName("異常値・例外のテスト")
    class ExceptionTests {

        @Test
        @DisplayName("金額がマイナス：IllegalArgumentExceptionが発生する")
        void testNegativeInputShouldThrowException() {
            assertThrows(IllegalArgumentException.class,
                    () -> calculator.calculateDiscount(-100));
        }
    }
}