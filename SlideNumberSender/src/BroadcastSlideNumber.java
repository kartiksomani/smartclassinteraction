import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class BroadcastSlideNumber {
	static int BROADCAST_PORT=9012;
		public static void main(String args[]){
			int num;
			DatagramSocket socket=null;
			try{
				if(args.length==1)
			num=Integer.parseInt(args[0]);
				else
					num=1;
			String data;
			socket=new DatagramSocket();
			InetAddress broadcast=InetAddress.getByName("127.0.0.1");
			data="Slide:"+num+":";
			DatagramPacket packet=new DatagramPacket(data.getBytes(),data.getBytes().length, broadcast, BROADCAST_PORT);
			
				socket.send(packet);
				socket.close();
			}
			
			catch(Exception ex){
				socket.close();
				ex.printStackTrace();
			}
		}
}
