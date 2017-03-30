package concurrency.base;

public class Joiner extends Thread {

	
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	public void run() {
		try {
			System.out.println(getName() + "joiner start");
			sleeper.join();
		
			System.out.println(getName() + "joiner stop");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName() + "join completed");
	}
	
	
}
