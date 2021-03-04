import java.util.Random;
import java.util.Scanner;
class Minimum
{
	public int min(int a, int b)
	{
	if(a<b)
		return a ;
	else
		return b ;
	}
}
class Leaky2
{
	public static int drop;
	public static void main(String args[])
	{	
		Minimum m =new Minimum();
		Random Rg=new Random();
		Scanner s = new Scanner(System.in);
		int bsize, count=0, orate, i,n; 
		int inp[]=new int[10];
		System.out.println("Enter the bucket size");
		bsize=s.nextInt();
		System.out.println("Enter the output rate");
		orate=s.nextInt();
		System.out.println("Enter number of time u want to simulate input");
		n=s.nextInt();
		for(i=0;i<n;i++)
		{
			inp[i] = Rg.nextInt(100); // inp[i] holds the number of incoming packets at the ith second
			System.out.println("Input at i = " +( i + 1) + " is\t" + inp[i]);
		}
		int mini;
		System.out.println("Sec | input |Packets sent |packets left| drop");
		for (i = 0; i < n; i++)
		{
			count = count + inp[i]; // count is the number of packets currently present in the bucket
			if (count > bsize) {    // if this condition is true then packets will be dropped from the bucket
				drop = count - bsize;
				count = bsize;
			}
			mini = m.min(orate, count); // mini is the number of packets sent
			count = count - mini; 
			System.out.print((i+1)+"\t"+inp[i]+"\t"+mini+"\t"+count+"\t"+drop+"\n");
			drop = 0; 
		}
		for (; count != 0; i++)
		{
			
			if (count > bsize) {
				drop = count - bsize;
				count = bsize;
			}
			mini = m.min(orate, count);
			count = count - mini;
			System.out.print((i+1)+"\t"+inp[i]+"\t"+mini+"\t"+count+"\t"+drop+"\n");
			drop = 0;
		}
	}
}

