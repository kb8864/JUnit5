package sec3.spy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorMockTest {

    @Mock
    Calculator mockCalculator; // ★ 完全にダミーのモック（中身はすべて空の動作）

    @Test
    void addもmultiplyも振る舞いを定義しないと使えない() {
        // ★ モックでは振る舞いを定義しないと、戻り値はデフォルト（intなら0）
        assertEquals(0, mockCalculator.add(3, 4));
        assertEquals(0, mockCalculator.multiply(3, 4));

        // ★ 動作を定義
        when(mockCalculator.add(3, 4)).thenReturn(7);
        when(mockCalculator.multiply(3, 4)).thenReturn(12);

        assertEquals(7, mockCalculator.add(3, 4));
        assertEquals(12, mockCalculator.multiply(3, 4));
    }
}
