import java.io.*;

public class PrinterEnterAppl {

	public static void main(String[] args) throws IOException {
		int nEnter = Integer.parseInt(args[0]);
		String strSymbol = args[1];		
		System.out.println(nEnter);
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		Printer printer = new Printer(strSymbol);
		printer.setDaemon(true);
		printer.start();
		
		int i=0;
		while(true){
			String line = console.readLine();
			printer.interrupt();
			i++;
			if ((i>nEnter)||(line.equalsIgnoreCase("exit")))	
				return;
		}
	}

}
