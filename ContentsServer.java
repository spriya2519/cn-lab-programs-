//TCP Server
import java.net.*;
import java.io.*;
public class ContentsServer
{
	public static void main(String args[]) throws Exception
	{
		ServerSocket sersock = new ServerSocket(4000);
		System.out.println("Server Ready for Connection");
		Socket sock = sersock.accept();
		System.out.println("Connection is successfull");
		InputStream istream = sock.getInputStream();
	BufferedReader fileRead = new BufferedReader(new InputStreamReader (istream));
		String fname = fileRead.readLine();
		System.out.println("Reading fie Contents"+fname);
		BufferedReader ContentRead = new BufferedReader(new FileReader(fname));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream,true);
		String str;
		while((str = ContentRead.readLine())!= null)
		{
			pwrite.println(str);
		}
		System.out.println("\n Sending file content to Client");
		sock.close();	
		sersock.close();
		pwrite.close();
		fileRead.close();
		ContentRead.close();
	}
}
	
