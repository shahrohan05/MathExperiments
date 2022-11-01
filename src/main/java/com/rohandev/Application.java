package com.rohandev;

import com.rohandev.experiment.SumToN;

public class Application {
    public static void main(String[] args) {
        CommandLineExperiment experiment = new SumToN();
        experiment.start();
    }
}
