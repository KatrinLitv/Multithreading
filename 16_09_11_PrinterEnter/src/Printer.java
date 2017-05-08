
public class Printer extends Thread {
String symbols;

public Printer(String symbols) {
	super();
	this.symbols = symbols;
}
@Override
public void run(){
	char [] print = symbols.toCharArray();
	int i=0;
	int maxSize=print.length;
	while(true){
		try {
			if (i==maxSize)
				i=0;
			System.out.print(print[i]);
			sleep(100);
			
		} catch (InterruptedException e) {
			i++;
			if (i>maxSize)
				i=0;
		}
	}
}
}
