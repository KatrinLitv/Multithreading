
public class Printer extends Thread {
@Override
public void run(){
	while(true) {
		try {
			sleep(100);
			System.out.print("#");
		} catch (InterruptedException e) {
			return;
		}		
	}
}
}
