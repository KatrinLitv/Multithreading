import java.time.*;

public class Timer extends Thread {
	public Timer () {
		setDaemon(true);
	}
	
public void run(){
	while (true) {
		try {
			sleep(1000);
		} catch (InterruptedException e) {

		}
		System.out.println(LocalDateTime.now());
	}
}

}
