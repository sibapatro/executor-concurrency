package com.learn.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UsingScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService  scheduledExecutorService= Executors.newScheduledThreadPool(10);
		//Runs after given delay
		scheduledExecutorService.schedule(new RunnableTask(),10, TimeUnit.SECONDS);
		//Runs every 10 secs with  15 sec initial delay
		scheduledExecutorService.scheduleAtFixedRate(new RunnableTask(), 15, 10, TimeUnit.SECONDS);
		//Runs repeatedly after 10 seconds of execution of previous task
		scheduledExecutorService.scheduleWithFixedDelay(new RunnableTask(), 15, 10, TimeUnit.SECONDS);

		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}
}
