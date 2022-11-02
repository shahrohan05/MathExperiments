package com.rohandev.experiment;

import com.rohandev.CommandLineExperiment;

import java.util.logging.Level;
import java.util.stream.IntStream;

public class SumToN implements CommandLineExperiment {

    @Override
    public void start(){
        try {
            startExperiment("Addition of natural numbers up-to N");
            int n = Integer.valueOf(getInput("Value of N (To add 1 to N)"));
            executeTask(() -> addThroughLoop(n), "Normal for loop");
            executeTask(() -> addThroughIntStream(n), "Java int stream");
            executeTask(() -> addThroughGaussFormula(n), "Gauss formula");

            executeTask(() -> addEvenNumbersThroughLoop(n),"Even numbers through loop");
            executeTask(() -> addEvenNumbersThroughGaussFormula(n),"Even numbers through Gauss formula");

            executeTask(() -> addAtoNThroughLoop(5,n), "A(5) to N through loop");
            executeTask(() -> addAtoNThroughGaussFormula(5,n), "A(5) to N through Gauss formula");

        } catch(Exception e) {
          CommandLineExperiment.LOG.log(Level.SEVERE, e.getLocalizedMessage());
        }

    }


    private void addAtoNThroughGaussFormula(int a, int n) {
        long sum = ((n * (n+1)) / 2 ) - ((a * (a+1)) /2);
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }

    private void addAtoNThroughLoop(int a, int n) {
        long sum = 0;
        for(int i = a; i <= n; i++) {
            sum += i;
        }
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }

    private void addEvenNumbersThroughGaussFormula(int n) {
        // sum of upto n/2 * 2
        long sum = (n/2) * ((n/2) + 1);
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }

    private void addEvenNumbersThroughLoop(int n) {
        long sum = 0;
        for(int i = 2; i <= n; i += 2) {
            sum += i;
        }
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }

    private void addThroughGaussFormula(int n) {
        long sum = (n * (n + 1) ) / 2;
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }


    private void addThroughIntStream(int n) {
        // works fast, but can produce incorrect results due to parallelism
        long sum = IntStream.range(1,n).sum();
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }

    private void addThroughLoop(int n) {
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        CommandLineExperiment.LOG.log(Level.INFO, "Result - "+sum);
    }




}
