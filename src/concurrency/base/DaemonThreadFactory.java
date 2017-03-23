package concurrency.base;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

	public DaemonThreadFactory() {
	}

	public Thread newThread(Runnable r) {

		Thread thread =  new Thread(r);
		
//		设置守护线程，其实守护线程就是后台线程，主进程结束后守护线程推出，也就是他在后面跑 主进程结束了她才结束
		thread.setDaemon(true);
		
		return thread;
	}
	
	

}
