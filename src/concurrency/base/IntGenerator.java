package concurrency.base;

public abstract class IntGenerator {

	private volatile boolean cancled = false;
	public abstract int next();
	public void cancel() {
		cancled = true;
	}
	public boolean isCancel() {
		return cancled;
	}
	
}
