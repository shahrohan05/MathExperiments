package com.rohandev.experiment;

import com.rohandev.CommandLineExperiment;

import java.util.logging.Level;

public class SumToN implements CommandLineExperiment {

    @Override
    public void start(){
        try {
            startExperiment("Addition of natural numbers up-to N");
            int n = Integer.valueOf(getInput("Value of N (To add 1 to N)"));
            executeTask(() -> addThroughLoop(n), "Normal for loop");
            executeTask(() -> addThroughGaussFormula(n), "Gauss Formula");

        } catch(Exception e) {
          CommandLineExperiment.LOG.log(Level.SEVERE, e.getLocalizedMessage());
        }

    }

    private void addThroughGaussFormula(int n) {
        long sum = (n * (n + 1) ) / 2;
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
