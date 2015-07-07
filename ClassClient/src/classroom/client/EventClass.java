package classroom.client;

import java.util.ArrayList;
import java.util.EventObject;

public class EventClass {
	ArrayList<GUIListener> clientListeners;
	
	public EventClass(){
		this.clientListeners=new ArrayList<GUIListener>();
	}
	public void addListener(GUIListener listener){
		this.clientListeners.add(listener);
	}
	public void fireEvent(AppEvent e){
		Object[] listeners=this.clientListeners.toArray();
		for(Object listener:listeners){
			if(listener==GUIListener.class){
				((GUIListener)listener).addMessage(e);
			}
		}
	}
}
