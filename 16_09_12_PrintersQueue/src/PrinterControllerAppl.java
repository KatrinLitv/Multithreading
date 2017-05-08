
public class PrinterControllerAppl {

	private static final int PORTION = 3;
	private static final int N_PORTIONS = 10;

	public static void main(String[] args) {
		Printer.setPortion(PORTION);
		Printer.setnPortions(N_PORTIONS);
		int nPrinters = Integer.parseInt(args[0]);
		Thread threads [] = createThreads(nPrinters);
		//System.out.println(nPrinters);
		startThreads(threads);

	}

	private static void startThreads(Thread[] threads){
		synchronized (threads[0]) {
		for (byte i=0 ; i<threads.length ; i++){			
			try {
				threads[i].start();
				threads[i].wait(1000);
			} catch (Exception e) {
			}
		}
		threads[0].notify();		
		}
	}

	private static Thread[] createThreads(int nPrinters) {
		Printer printers [] = new Printer[nPrinters];
		Thread res [] = new Thread[nPrinters];
		for (byte i=0 ; i<nPrinters ; i++) {
			printers[i]=new Printer(i);
			res[i]=new Thread(printers[i],"Priner ¹"+i);
		}
		
		for (byte i=0 ; i<(nPrinters-1) ; i++) {
			printers[i].setThread(res[i+1]);
				//res[i]=new Thread(new Printer(i,(i==0)?res[nPrinters-1]:res[i-1]),"Priner ¹"+i);				
		}
		printers[nPrinters-1].setThread(res[0]);
		return res;
	}

}
