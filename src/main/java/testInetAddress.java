import java.net.InetAddress;
import java.net.UnknownHostException;


public class testInetAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub

		InetAddress address = InetAddress.getLocalHost();
		
	//	InetAddress address2 = InetAddress.getByAddress("219.141.230.149".getBytes());
		System.out.println(address.getHostName() + "," + address.getHostAddress());
	//	System.out.println(address2.getHostName() + "," + address2.getHostAddress());
	}

}
