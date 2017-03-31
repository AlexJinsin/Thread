package concurrency;

 

class DualSynch {
  private Object syncObject = new Object();
  private final Object lockObject = new Object();
  public synchronized void f() {
    for(int i = 0; i < 5; i++) {
      System.out.println("f()");
      Thread.yield();//线程执行到这可以交付其他线程运行 但是我这个程序还是要走完的 只不过我让别的线程去运行而已
    }
  }
  public  void g() {
    synchronized(syncObject) {
      for(int i = 0; i < 5; i++) {
    	  System.out.println("g()");
        Thread.yield();
      }
    }
  }
  public  void x() {
	  synchronized (this) {

	      for(int i = 0; i < 5; i++) {
	    	  System.out.println("x()");
	        Thread.yield();
	      }
	    
	}
  }
}

public class SyncObject {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      public void run() {
        ds.f();
      }
    }.start();
    new Thread() {
        public void run() {
          ds.x();
        }
      }.start();
    ds.g();
  }
} /* Output: (Sample)
g()
f()
g()
f()
g()
f()
g()
f()
g()
f()
*///:~
