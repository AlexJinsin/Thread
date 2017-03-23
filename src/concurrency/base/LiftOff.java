package concurrency.base;

public class LiftOff implements Runnable{

	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff(int countDown) {
	
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "==" + countDown;
	}
	
	public void run() {
		while (countDown-- >0) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(status());
		}
		
	}
	public static void main(String[] args) {
		LiftOff aLiftOff = new LiftOff(5);
		aLiftOff.run();
	}
	
	
}
