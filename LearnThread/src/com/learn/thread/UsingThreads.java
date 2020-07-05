package com.learn.thread;

public class UsingThreads {

	public static void main(String[] args) {
		for(int i = 0 ; i <1000 ; i++) {
			Thread mythread = new Thread(new RunnableTask());
			mythread.start();
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}

}
