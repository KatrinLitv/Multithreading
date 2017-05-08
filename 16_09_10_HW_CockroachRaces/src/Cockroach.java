import java.util.Random;

public class Cockroach implements Runnable {
private static final int DEFAULT_N_ITERATIONS = 100;
private static final int MAX_TIME = 10;
final Random random = new Random();

public Cockroach(int nIterations, int maxTime) {
	super();
	this.nIterations = nIterations;
	this.maxTime = maxTime;
}

public int getnIterations() {
	return nIterations;
}

public int getMaxTime() {
	return maxTime;
}

public void setnIterations(int nIterations) {
	this.nIterations = nIterations;
}

public void setMaxTime(int maxTime) {
	this.maxTime = maxTime;
}

private int nIterations = DEFAULT_N_ITERATIONS;
private int maxTime = MAX_TIME;

	@Override
	public void run() {
		long time = System.currentTimeMillis();
		for (int i=0 ; i< nIterations; i++)			
			pause(random.nextInt(maxTime));
		System.out.println(Thread.currentThread().getName() + "  time: "+(System.currentTimeMillis()-time));
	}

	private void pause(int tSleep) {
		try {
			Thread.sleep(tSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

}
