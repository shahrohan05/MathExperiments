package com.rohandev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface CommandLineExperiment {
    Logger LOG = Logger.getLogger(CommandLineExperiment.class.getName());
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void start();

    default void startExperiment(String name) {
        String decoration = "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-";
        System.out.print("\n"+decoration+"\n"+name+"\n"+decoration+"\n");
    }
    default String getInput(String requestLabel) {
        System.out.print(requestLabel+": ");
        try {
            return reader.readLine();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
        }
        return "";
    }

    default long getCurrentTimestamp(String label) {
        long currentTime = System.currentTimeMillis();
        //LOG.log(Level.INFO, "["+label+"] Timestamp -"+currentTime);
        return currentTime;
    }

    default void executeTask(Runnable task, String taskName) {
        long startTime = getCurrentTimestamp("START - "+taskName);
        task.run();
        long endTime = getCurrentTimestamp("END - "+taskName);
        LOG.log(Level.INFO, taskName+ " took - "+(endTime - startTime) + " millis.");
    }

}
