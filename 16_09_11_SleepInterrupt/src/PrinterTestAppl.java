import java.io.*;

public class PrinterTestAppl {

	public static void main(String[] args) throws IOException {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Printer printer = new Printer();
		printer.start();
		while(true){
			String line = console.readLine();
			if (line.equalsIgnoreCase("exit")){
				printer.interrupt();
				return;
			}
		}
	}

}
