package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Receiver extends Thread {
	private MessageBox messageBox;

public Receiver(MessageBox message) {
	super();
	this.messageBox = message;
	setDaemon(true);
}

@Override
public void run(){
	while(true){
		System.out.println(getName() + " "+messageBox.getMessage());
		
	}
}

}
