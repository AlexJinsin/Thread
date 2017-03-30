package concurrency.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency.base.CaptureUncaughtExecption.ExeptionThread2;
import concurrency.base.CaptureUncaughtExecption.HanderThreadFactory;

public class Joining {

//	public static void main(String[] args) {
//		Sleeper sleeper = new Sleeper("sleeper", 1500);
//		Sleeper grumpy = new Sleeper("grumpy", 1500);
//		
//		Joiner dopey = new Joiner("Dopey", sleeper);
//		Joiner doc = new Joiner("Doc", grumpy);
//		grumpy.interrupt();
//	}
	
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool(new HanderThreadFactory());
		executorService.execute(new ExeptionThread2());
	}
}

