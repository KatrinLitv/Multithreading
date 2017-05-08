
public class Worker extends Thread {	
static Object m1 = new Object();
static Object m2 = new Object();

@Override
public void run(){
	try {
		f1();
		f2();
	} catch (Exception e) {
		
	}
}

private void f2() throws InterruptedException {
	synchronized (m2) {
		sleep(10);
		synchronized (m1) {			
		}		
	}
}

private void f1() {
	synchronized (m1) {
		synchronized (m2) {			
		}		
	}
	
}
}
