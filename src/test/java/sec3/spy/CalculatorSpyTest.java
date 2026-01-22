package sec3.spy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorSpyTest {

    @Spy
    Calculator spyCalculator; // ★ 実インスタンスのスパイ（本物＋一部だけ変更可能）

    @Test
    void multiplyだけモックしてaddは本物を使う() {
        // ★ multiplyだけを上書き
        doReturn(100).when(spyCalculator).multiply(3, 4);

        // addは本来のロジックが使われる
        assertEquals(7, spyCalculator.add(3, 4));

        // multiplyはモックの値が返る
        assertEquals(100, spyCalculator.multiply(3, 4));
    }
}
