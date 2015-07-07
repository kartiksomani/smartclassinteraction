package classroom.client;

import java.util.EventListener;

public interface GUIListener extends EventListener{
	public void addMessage(AppEvent e);
}
