package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadPool {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for(int i =0 ; i< 1000; i++) {
			executorService.execute(new RunnableTask() );
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}
}
