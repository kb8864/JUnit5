package sec2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {
    private DiscountCalculator calculator;

    @BeforeEach
    void setup(){
        calculator = new DiscountCalculator();

    }
    @Test
    @DisplayName("金額4999円未満なら割引はなし")
    void test4999(){
        assertEquals(0.0, calculator.calculateDiscount(4999));

    }
    @Test
    @DisplayName("金額5000円。割引は5％割引。下限")
    void test5000(){
        assertEquals(250.0, calculator.calculateDiscount(5000));

    }
    @Test
    @DisplayName("金額9999円。割引は5％割引。上限")
    void test9999(){
        assertEquals(499.95, calculator.calculateDiscount(9999), 0.01);

    }


}