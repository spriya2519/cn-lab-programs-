//RSA
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

//Inbuilt Methods Used in this Program Which is there in BigInteger Class of math package
//probablePrime() 	- This method returns a positive BigInteger that is probably prime, with the specified bitLength.
//multiply ()	- This method returns a BigInteger whose value is (this * val).
//gcd()		- This method returns a BigInteger whose value is the greatest common divisor of abs(this) and abs(val).
//compareTo() 	- This method compares this BigInteger with the specified BigInteger.	
//add()		- This method returns a BigInteger whose value is (this + val)
//modInverse()	- This method returns a BigInteger whose value is (this-1 mod m).
//modPow()	- This method returns a BigInteger whose value is (thisexponent mod m).
public class RSA
{
        private BigInteger p;
        private BigInteger q;
        private BigInteger N;
        private BigInteger phi;
        private BigInteger e;
        private BigInteger d;
        private int  bitlength = 1024;
        private Random     r;
	public RSA()
	{
	            r = new Random();//Genaretes a random number
		System.out.println("Randome Number is \n"+r);			
	            p = BigInteger.probablePrime(bitlength, r);

		System.out.println("The prime value of 'P' =\n"+p);
	            q = BigInteger.probablePrime(bitlength, r);
				System.out.println("The prime value of 'Q' ="+q);
	            N = p.multiply(q);
		
		System.out.println("N=P*Q"+N);
	            phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
				System.out.println("The value of 'PhI(n)' ="+phi);//phi(N)=(p-1)*(q-1)
	            e = BigInteger.probablePrime(bitlength / 2, r);
				System.out.println("The prime value of 'e' ="+e);
	            while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
	            {
			e.add(BigInteger.ONE);
			
	            }
	            d = e.modInverse(phi);
	 }
	public RSA(BigInteger e, BigInteger d, BigInteger N)
	{
		this.e = e;
		this.d = d;
		this.N = N;
	}
        @SuppressWarnings("deprecation")
	        public static void main(String[] args) throws IOException
	        {
	            RSA rsa = new RSA();
	            DataInputStream in = new DataInputStream(System.in);
	            String teststring;
	            System.out.println("Enter the plain text:");
	            teststring = in.readLine();
	            System.out.println("Encrypting String: " + teststring);
	            System.out.println("String in Bytes: "+ bytesToString(teststring.getBytes()));
	           // encrypt
	            byte[] encrypted = rsa.encrypt(teststring.getBytes());
	            // decrypt
	            byte[] decrypted = rsa.decrypt(encrypted);
	            System.out.println("Decrypting Bytes: " + bytesToString(decrypted));
	            System.out.println("Decrypted String: " + new String(decrypted));
	        }
	 private static String bytesToString(byte[] encrypted)
	 {
	           String test = "";
		for (byte b : encrypted)
		{
  	  	            test += Byte.toString(b);
		}

	            return test;
	 }

	// Encrypt message
	 public byte[] encrypt(byte[] message)
	 {
	           return (new BigInteger(message)).modPow(e, N).toByteArray();

	  }

	 // Decrypt message
	public byte[] decrypt(byte[] message)
	{
		return (new BigInteger(message)).modPow(d, N).toByteArray();

	}

}

