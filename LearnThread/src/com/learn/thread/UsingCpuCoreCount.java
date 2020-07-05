package com.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCpuCoreCount {
	public static void main(String[] args) {
		int cpuCore = Runtime.getRuntime().availableProcessors();
		System.out.println("Total Cpu Cores ::" +  cpuCore);
		ExecutorService executorService = Executors.newFixedThreadPool(cpuCore);
		for(int i =0 ; i< 1000; i++) {
			executorService.execute(new RunnableTask() );
		}
		System.out.println("Thread Name :: " +Thread.currentThread().getName());
		executorService.shutdown();
	}
}
