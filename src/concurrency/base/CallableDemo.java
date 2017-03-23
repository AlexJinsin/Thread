package concurrency.base;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			result.add(executorService.submit(new TaskWithResult(i)));
		}
		
		for (Future<String> fs :result) {
			
			if (fs.isDone()) {

				System.out.println(fs.get());
			}else {
				System.out.println("mei wan shi");
			}
		}
		
	}
}


class TaskWithResult implements Callable<String> {

	private int id;
	
	
	public TaskWithResult(int id) {
		this.id = id;
	}
	
	public String call() throws Exception {
		Thread.sleep(id%5*1000);
		TimeUnit.SECONDS.sleep(1);
		return "task result id:" + id;
	}
	
}