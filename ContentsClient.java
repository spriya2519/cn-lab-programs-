//TCP client
import java.net.*;
import java.io.*;
public class ContentsClient
{
	public static void main(String args[]) throws Exception
	{
		Socket sock = new Socket("127.0.0.1",4000);
		System.out.println("Enter the file Name");
	BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in));
		String fname = KeyRead.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		System.out.print("Sending file to Server \n");
		pwrite.println(fname);
		InputStream istream = sock.getInputStream();
		BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str = socketRead.readLine())!=null)
		{
			System.out.println(str);
		}
		pwrite.close();
		socketRead.close();
		KeyRead.close();
	}
}
