
public class Printer extends Thread {
byte id;
Thread threadLink;
static int portion;
static int nPortions;

private static final Object monitor = new Object();
private static boolean ready = false;


//public Printer(byte id, Thread threadLink) {
public Printer(byte id) {
	super();
	this.id = id;
	//this.threadLink = threadLink;
}


public static void setPortion(int portion) {
	Printer.portion = portion;
}


public static void setnPortions(int nPortions) {
	Printer.nPortions = nPortions;
}


public void setThread(Thread thread) {
	this.threadLink = thread;
}


@Override
public void run(){
	synchronized (monitor) {
	for (int j = 0; j < nPortions; j++) {
		for (int i = 0; i < portion; i++)
			System.out.print(id);
		try {
			System.out.println(threadLink.getName());
			wait();			
			threadLink.notify();

		} catch (InterruptedException e) {

		} 
	}	
	}
}

}
