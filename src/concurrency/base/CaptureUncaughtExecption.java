package concurrency.base;

import java.util.concurrent.ThreadFactory;

public class CaptureUncaughtExecption {
	
	public static void main(String[] args) {
		
		
		
	}
	
	class ExeptionThread2 implements Runnable {

		@Override
		public void run() {
			
			Thread thread = Thread.currentThread();
			System.out.println("run() by:" + thread);
			System.out.println("eh = " + thread.getUncaughtExceptionHandler());
			throw new RuntimeException();
			
		}
	}
	
	class MyUncaughtExecptionHander implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// TODO Auto-generated method stub
			System.out.println("caught " + e);
		}
	}
	
	class HanderThreadFactory implements ThreadFactory {

		@Override
		public Thread newThread(Runnable r) {

			System.out.println(this + " carting new thread");
			Thread thread = new Thread(r);
			thread.setUncaughtExceptionHandler(new MyUncaughtExecptionHander());
			System.out.println("eh = " + thread.getUncaughtExceptionHandler());
			return thread;
			
		}
		
	
	}
}
