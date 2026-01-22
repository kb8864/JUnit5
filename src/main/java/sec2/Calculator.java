package sec2;

public class Calculator {

    // 足し算を行うメソッド
    public int add(int a, int b) {
        return a + b;
    }

    // 引き算を行うメソッド
    public int subtract(int a, int b) {
        return a - b;
    }

    // 掛け算を行うメソッド
    public int multiply(int a, int b) {
        return a * b;
    }

    // 割り算を行うメソッド
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("0で割ることはできません");
        }
        return a / b;
    }
}

