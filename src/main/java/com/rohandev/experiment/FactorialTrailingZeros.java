package com.rohandev.experiment;

import com.rohandev.CommandLineExperiment;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialTrailingZeros implements CommandLineExperiment {


    @Override
    public void start() {
        startExperiment("Find trailing zeros in the factorial of a given number");
        int n = Integer.valueOf(getInput("Value of N"));
        executeTask(() -> findTrailingZerosFromFactorial(n), "Trailing zeros from factorial");
        executeTask(() -> findTrailingZerosFromFactorialWithBigInt(n), "[BIG INT] Trailing zeros from factorial");
        executeTask(() -> findTrailingZerosFromFactorialWithBigIntStream(n), "[BIG INT STREAM] Trailing zeros from factorial");
        // Interesting results [division by 5 solution tool the longest time] -
        /*  INFO: Trailing zeros from factorial took - 7 millis.
            INFO: [BIG INT] Trailing zeros from factorial took - 3 millis.
            INFO: [BIG INT STREAM] Trailing zeros from factorial took - 1 millis.
        * */
    }

    private void findTrailingZerosFromFactorialWithBigIntStream(int n) {
        BigInteger factorial = IntStream.range(2, n+1).mapToObj(i -> BigInteger.valueOf(i)).reduce(BigInteger.ONE, (i, j) -> i.multiply(j));

        BigInteger temp = factorial;
        BigInteger j = temp.mod(BigInteger.TEN);
        temp = temp.divide(BigInteger.TEN);
        int count = 0;
        while(j.equals(BigInteger.ZERO)) {
            count++;
            j = temp.mod(BigInteger.TEN);
            temp = temp.divide(BigInteger.TEN);
        }

        System.out.println("for N "+n+", factorial is "+factorial+" and trailing zero count is "+count);
    }

    private void findTrailingZerosFromFactorialWithBigInt(int n) {
        BigInteger factorial = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger temp = factorial;
        BigInteger j = temp.mod(BigInteger.TEN);
        temp = temp.divide(BigInteger.TEN);
        int count = 0;
        while(j.equals(BigInteger.ZERO)) {
            count++;
            j = temp.mod(BigInteger.TEN);
            temp = temp.divide(BigInteger.TEN);
        }
        System.out.println("for N "+n+", factorial is "+factorial+" and trailing zero count is "+count);
    }

    private void findTrailingZerosFromFactorial(int n) {
        // Initialize result
        int count = 0;

        if (n < 0) // Negative Number Edge Case
            count = -1;

        // Keep dividing n by powers
        // of 5 and update count
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;

        System.out.println("for N "+n+" zero count in factorial is "+count);
    }

    public static void main(String[] args) {
        FactorialTrailingZeros o = new FactorialTrailingZeros();
        o.start();
    }
}
