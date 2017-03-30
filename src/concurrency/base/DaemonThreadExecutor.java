package concurrency.base;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DaemonThreadExecutor extends ThreadPoolExecutor{

	public DaemonThreadExecutor() {
		
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(),new DaemonThreadFactory());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
