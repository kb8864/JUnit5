package sec1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {
    @Test
    void testAdd(){
        //Arrange：「登場人物（準備）」
        Adder cal = new Adder();
        //Act：「行動（メソッド呼び出し）」
        int actual = cal.add(2, 3);
        //Assert：「結果（期待通りか）」
        assertEquals(5, actual);
    }
}
