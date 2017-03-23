package concurrency.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PartOne {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			executorService.execute(new LiftOff(5));
			
		}
		executorService.shutdown();
	}
//	public static void main(String[] args) {
//		
//		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		for (int i = 0; i < 10; i++) {
//			executorService.execute(new LiftOff(5));
//			
//		}
//		executorService.shutdown();
//	}
	
//	public static void main(String[] args) {
//		
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		for (int i = 0; i < 10; i++) {
//			executorService.execute(new LiftOff(5));
//			
//		}
//		executorService.shutdown();
//	}
	
}
