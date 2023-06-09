// package com.journaldev.threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    
    @Override
    public void run() {
        System.out.println("Timer task started at: "+new Date());
        completeTask();
        System.out.println("Timer task finished at: "+new Date());
    }

    private void completeTask() {
        try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(1000); //20000
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimerTask timerTask = new MyTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1*1000);
        System.out.println("TimerTaskCountdown started");
        //cancel after sometime
        try {
            Thread.sleep(10000); //120000
        } catch (InterruptedException e) { 
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTaskCountdown cancelled");
        try {
            Thread.sleep(3000); //120000
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Timing out now. Good bye");
    }
}