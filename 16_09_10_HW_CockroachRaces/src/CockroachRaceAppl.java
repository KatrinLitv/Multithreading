import java.util.*;

public class CockroachRaceAppl {
	static int nIterations = 0;
	static int maxTime = 0;
	static int nCockroach = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter distance: ");
		String nIterationsStr = in.nextLine();
		System.out.print("Enter max time of delay: ");
		String maxTimeStr = in.nextLine();		
		System.out.print("Enter number of cockroaches: ");
		String nCockroachStr = in.nextLine();
		
		try {
			nIterations = Integer.parseInt(nIterationsStr);
			maxTime = Integer.parseInt(maxTimeStr);
			nCockroach = Integer.parseInt(nCockroachStr);
		} catch (NumberFormatException e) {
			System.out.println("Wrong data format!!!");
		}
		joinThreads(startRace(nCockroach));
		//startRace(nCockroach);
	}

	private static void joinThreads(Thread[] threads) throws InterruptedException {
		for (Thread thread : threads)
			thread.join();
	}

	private static Thread [] startRace(int nCockroach) {
		Thread [] threads = new Thread[nCockroach];
		for (int i=0; i<nCockroach; i++){
			threads[i]=new Thread(new Cockroach(nIterations, maxTime),"Cockroach ¹" + i);
			threads[i].start();
		}			
		return threads;
	}

}
