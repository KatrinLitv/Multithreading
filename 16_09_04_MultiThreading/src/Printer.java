
public class Printer implements Runnable {
private static final char DEFAULT_SYMBOL = '*';
private static final int DEFAULT_N_ITERATIONS = 10;

private char symbol=DEFAULT_SYMBOL;
private int nIterations = DEFAULT_N_ITERATIONS;

public Printer () {}

public char getSymbol() {
	return symbol;
}

public int getnIterations() {
	return nIterations;
}

public void setSymbol(char symbol) {
	this.symbol = symbol;
}

public void setnIterations(int nIterations) {
	this.nIterations = nIterations;
}

public Printer(char symbol, int nIterations) {
	super();
	this.symbol = symbol;
	this.nIterations = nIterations;
}


	@Override
	public void run() {
		for (int i=0 ; i<nIterations ; i++){
			System.out.println(symbol+ " "+Thread.currentThread().getName());
			pause(100);
		}
	}

	private void pause(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
