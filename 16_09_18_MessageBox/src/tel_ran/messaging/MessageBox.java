package tel_ran.messaging;

public class MessageBox {
private String message;

synchronized public void putMessage(String message){
	while (this.message != null) {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted ");
		}
	}
	this.message = message;
	this.notify();
	
}

synchronized public String getMessage(){
	while(this.message==null){
		try {
			this.wait();
		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted ");
		}
	}
	//Пока выполняются след. действия никто не может перехватить и изменить 
	// this.message, т.к. все находится в методе synchronized
	String message = this.message;
	this.message = null;
	// notifyAll -будит всех, иначе все спят
	//notify  может разбудить  нисаого кого надо
	this.notifyAll();
	return message;
}
}
