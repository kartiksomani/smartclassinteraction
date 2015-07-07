package classroom.client;

import java.util.EventObject;

public class AppEvent extends EventObject {
	String message;
	public AppEvent(Object source,String message){
		super(source);
		this.message=message;
	}
}
