package classroom.server;
import java.io.File;

import org.apache.ftpserver.*;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.BaseUser;
public class DistributorMain {
	public static void main(String args[]){
		String username,password,portStr,folder;
		int port;
		UserManager um;
		if(args.length<4){
			System.out.println("Usage: java -jar Distribution.jar <username> <password> <port> <folder>");
			return;
		}
		try {
		username=args[0];
		password=args[1];
		portStr=args[2];
		port=Integer.parseInt(portStr);
		folder=args[3];
		FtpServerFactory serverFactory = new FtpServerFactory();
		ListenerFactory factory = new ListenerFactory();
		// set the port of the listener
		factory.setPort(port);
		
		// replace the default listener
		um=getUM(username,password,folder);
		serverFactory.setUserManager(um);
		serverFactory.addListener("default", factory.createListener());
		// start the server
		FtpServer server = serverFactory.createServer();         
		
			server.start();
		} catch (FtpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private static UserManager getUM(String username,String password,String directory) throws FtpException{
	PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
	UserManager um = userManagerFactory.createUserManager();
	BaseUser user = new BaseUser();
	user.setName(username);
	user.setPassword(password);
	user.setHomeDirectory(directory);
	um.save(user);
	return um;
}
	
}
