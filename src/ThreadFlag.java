




public class ThreadFlag extends Thread {
	
	public volatile boolean exit = false;

	public void run() {
		
		while (!exit)
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static void main(String[] args) {
		
		ThreadFlag thread = new ThreadFlag();
		thread.start();
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 主线程延迟5秒
		thread.exit = true; // 终止线程thread
		System.out.println("aaa");
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("线程退出!");
	}
}