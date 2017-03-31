package concurrency.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{

	private  int i = 0;
	public synchronized int getValue() {
		return i;
	}
	
	private synchronized void evenInc() {
		i++;
		i++;
	}

	@Override
	public void run() {
		while (true) {
			
			evenInc();
		}
	}
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		AtomicityTest atomicityTest = new AtomicityTest();
		executorService.execute(atomicityTest);
		while (true) {

			int a = atomicityTest.getValue();
			if (a%2 != 0) {
				System.out.println(a);
			}
		}
	}
}
