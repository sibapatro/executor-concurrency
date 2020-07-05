package com.learn.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UsingCustomRejection {
	

	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(10, 100, 120, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<>(300),new MyCustomRejectionHandler());
		for(int i =0 ; i< 1000; i++) {
				executorService.execute(new RunnableTask() );
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
		
		
	}
	private static class MyCustomRejectionHandler implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println(" ^^^^^^^^^^^^^^^^^^^^^^^^^^^ Task rejected ^^^^^^^^^^^^^^^^^^^^^^^");
		}
		
		
	}
}
