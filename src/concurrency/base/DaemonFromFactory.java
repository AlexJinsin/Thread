package concurrency.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	public DaemonFromFactory() {
	}

	public void run() {
		try {
			System.out.println("asdfasdfasdf");
			TimeUnit.MILLISECONDS.sleep(100);
			
			System.out.println(Thread.currentThread() + "aaaa" + this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
			
		ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for (int i = 0; i < 10; i++) {
			executorService.execute(new DaemonFromFactory());
		}
		System.out.println("all start ");
		TimeUnit.MILLISECONDS.sleep(1000);
		executorService.shutdown();
			
	}

}
