package classroom.client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientListener extends Thread{
	EventClass ec;
	public void addGUIForEvents(GUIListener l){
		ec=new EventClass();
		ec.addListener(l);
	}
	ServerSocket ssocket;
	int port;
	String roomAddress;	//messages will be received from this address only
	public ClientListener(String roomAddress,int port) throws IOException{
		this.roomAddress=roomAddress;
		this.port=port;
		//ssocket= new ServerSocket(port);
	}
	
	public void run(){
		Socket s;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ec.fireEvent(new AppEvent(this, "This is a message"));
		/*while(true){
			try {
				//s=ssocket.accept();
				
			} catch (IOException e) {
				//TODO something about this exception
				continue;
			}
			
		}*/
	}
	public void receiveFile(Socket sock){
		
		//receive file name
		
		//send ack
		
		//receive file contents
	}
	
	public void saveFile(){
		
	}
}
