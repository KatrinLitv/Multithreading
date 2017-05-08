
public class PrinterControllerTestAppl {

	public static void main(String[] args) throws InterruptedException {
		long time = System.currentTimeMillis();
		Printer [] printers = {new Printer('&',10),new Printer(),new Printer('8',10)};
		//startPrinters(printers);
		joinPrinters(startPrinters(printers));
		//Thread.sleep(2000);
		System.out.println(System.currentTimeMillis()-time);		
	}

	private static void joinPrinters(Thread[] threads) throws InterruptedException {
		for(Thread thread : threads)
			thread.join();
	}

	private static Thread[] startPrinters(Printer[] printers) {
		Thread [] threads = new Thread[printers.length];
		for (int i=0; i< printers.length; i++){
			threads[i] = new Thread(printers[i]);
			threads[i].start();
		}	
		return threads;
	}

}
