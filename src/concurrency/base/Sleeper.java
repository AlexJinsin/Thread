package concurrency.base;

import java.awt.print.Printable;

public class Sleeper extends Thread {

	private int duration;
	
	public Sleeper(String name, int sleepTime) {
		
		super(name);
		duration = sleepTime;
		start();
	}
	
	public void run() {
		
		try {
			System.out.println(getName() + "sleeper start");
			sleep(duration);
			System.out.println(getName() + "sleeper stop");
		} catch (Exception e) {
			System.out.println(getName() + "was interrupted. " + "is interrupped():" + isInterrupted());
		}
	}
}
