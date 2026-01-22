package exercises;

public class SimpleCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0による除算はできません");
        }
        return a / b;
    }

    public void longProcess() {
        try {
            Thread.sleep(50); // 処理時間のシミュレーション
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}