package com.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingFixedThreadPoolCallable {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Future<Integer>> allFutures = new ArrayList<>();
		for(int i =0 ; i< 100; i++) {
			Future<Integer> future = executorService.submit(new CallableTask());
			allFutures.add(future);
		}
		
		
		for(Future<Integer> fut:allFutures) {
			try {
				Integer result = fut.get();
				System.out.println("Result of future "+ fut.toString() + " :: " + result);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}
	
	private static class CallableTask implements Callable<Integer>{

		@Override
		public Integer call() throws Exception {
			Thread.sleep(3000);
			return new Random().nextInt();
		}
		
	}
}
