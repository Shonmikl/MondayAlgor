package org.example._2023_04_24_intro;

public class App {
    public static long fibLoop(final int fibIndex) {
        var fib1 = -1L;
        var fib2 = 1L;

        for (int i = 0; i <= fibIndex; i++) {
            var current = fib1 + fib2;
            fib1 = fib2;
            fib2 = current;
        }
        return fib2;
    }

    public static long fibRec(final int fibIndex) {
        if (fibIndex < 0) {
            throw new IllegalArgumentException();
        }
        if (fibIndex == 0) {
            return 0;
        }
        return fibIndex == 1 || fibIndex == 2 ? 1L : fibRec(fibIndex - 2) + fibRec(fibIndex - 1);
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        fibLoop(50);
        System.out.println("LOOP: " + (System.currentTimeMillis() - time1));

        long time2 = System.currentTimeMillis();
        fibRec(50);
        System.out.println("REC: " + (System.currentTimeMillis() - time2));
    }
}