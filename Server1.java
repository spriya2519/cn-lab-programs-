//Server.java
import java.io.*;
import java.net.*;
import java.util.*;

public class Server1 {
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
try{
ServerSocket ss=new ServerSocket(6666);
Socket s=ss.accept();//establishes connection 
DataOutputStream dout=new DataOutputStream(s.getOutputStream());
System.out.println("Type the Message to be Sent to Client ");
dout.writeUTF(sc.nextLine());
dout.flush();
dout.close();
ss.close();

}catch(Exception e){System.out.println(e);}
}
}
