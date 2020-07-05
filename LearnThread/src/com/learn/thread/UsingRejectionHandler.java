package com.learn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UsingRejectionHandler {
	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(10, 100, 120, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<>(300));
		for(int i =0 ; i< 1000; i++) {
			try {
				executorService.execute(new RunnableTask() );
			}catch(RejectedExecutionException rejectedException) {
				System.out.println(" ^^^^^^^^^^^^^^^^^^^^^^^^^^^ Task rejected ^^^^^^^^^^^^^^^^^^^^^^^");
			}
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}
}
