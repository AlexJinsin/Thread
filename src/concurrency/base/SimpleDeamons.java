/**
 * 
 */
package concurrency.base;

import java.util.concurrent.TimeUnit;

/**
 * @author Alex
 *
 */
public class SimpleDeamons implements Runnable{

	/**
	 * 
	 */
	public SimpleDeamons() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			Thread demo = new Thread(new SimpleDeamons());
			demo.setDaemon(true);//设置后台执行线程
			demo.start();
			
		}
		System.out.println("stop  pppppp");
		TimeUnit.MILLISECONDS.sleep(100);
	}

	public void run() {

		try {
			while (true) {

				TimeUnit.MICROSECONDS.sleep(100);
				System.out.println(Thread.currentThread()+ ":  :" + this);
			}
		} catch (Exception e) {
			System.out.println("sleep intrupted ");
		}
	}

}



