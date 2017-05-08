
public class SomeAppl {

	public static void main(String[] args) {
		Timer timer = new Timer();
		//timer.setDaemon(true);
		timer.start();
		someFunction();

	}

	private static void someFunction() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
