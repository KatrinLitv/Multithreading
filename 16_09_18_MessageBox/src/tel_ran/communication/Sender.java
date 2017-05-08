package tel_ran.communication;

import tel_ran.messaging.MessageBox;

public class Sender extends Thread {
	private MessageBox messageBox;
	int nMessages=10;
	
public Sender(MessageBox messageBox) {
		super();
		this.messageBox = messageBox;
	}

public int getnMessages() {
	return nMessages;
}

public void setnMessages(int nMessages) {
	this.nMessages = nMessages;
}

@Override
public void run(){
	for (int i=1; i<=nMessages ; i++){
		messageBox.putMessage("message "+i);
//		try {
//			//sleep(10);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
}
