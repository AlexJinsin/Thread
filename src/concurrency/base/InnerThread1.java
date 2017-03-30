package concurrency.base;

//	 内敛的创造线程从而空出继承的位置这样可以让本class 继续继承其他的东西
public class InnerThread1 {

	private int countDown = 5;
	
	private class Inner extends Thread {
		private Inner(String name) {
			super(name);
			start();
		}

		public void run() {
			
			try {
			
				while (true) {

					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					sleep(10);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		public String toString(){
			return getName() + ":" + countDown;
		}
		
	}
	
	private Inner inner;
	
	public InnerThread1(String name) {
		inner = new Inner(name);
		
	}
	
	public static void main(String[] args) {
		new InnerThread1("aaa");
		
	}
}
