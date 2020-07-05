package com.learn.thread;

public class RunnableTask implements Runnable {
	//private static int i;
	@Override
	public void run() {
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
	}

}
