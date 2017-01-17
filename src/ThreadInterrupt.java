import java.io.IOException;













public class ThreadInterrupt extends Thread {

	private boolean start = true;
//	private volatile Thread blinker;

	public void interrupt() {
		start = false;
		super.interrupt();
	}

	public void run() {

		System.out.println("isInterrupted " + isInterrupted());
//		while (start) {
			while (ThreadInterrupt.currentThread().isInterrupted()) {

			try {
				sleep(100000); // 延迟50秒
			} catch (InterruptedException e) {
				System.out.println("thread error" + e.getMessage());
			}
		}

		System.out.println("isInterrupted " + isInterrupted());

	}

	public static void main(String[] args) throws IOException,
			InterruptedException {

		Thread thread = new ThreadInterrupt();
		thread.start();
		System.out.println("在50秒之内按任意键中断线程!");

		System.out.println(" main isInterrupted " + thread.isInterrupted());
		sleep(500);
		thread.interrupt();
		System.out.println(" main isInterrupted " + thread.isInterrupted());
		thread.join();
		System.out.println(" main isInterrupted " + thread.isInterrupted());

		System.out.println("线程已经退出!");
	}

	private volatile Thread blinker;

}