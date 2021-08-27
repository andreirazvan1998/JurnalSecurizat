import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.security.MessageDigest;

public class Encripting {
	
	private final static String ALGORITHM="SHA512";

	public static byte[] GnerateSalt()throws NoSuchAlgorithmException{
		
		SecureRandom sc=SecureRandom.getInstance("SHA1PRNG");
		byte[] salt=new byte[16];
		sc.nextBytes(salt);
		return salt;
	}
	
	public static byte[] Hashing(String password,byte[] salt) throws NoSuchAlgorithmException {
		MessageDigest dg=MessageDigest.getInstance(ALGORITHM);
		dg.reset();
		dg.update(salt);
		byte[] hash=dg.digest(password.getBytes());
		return hash; 
	}
	
	public static String bytesToHex(byte[] bytes) {
		String s = Base64.getEncoder().encodeToString(bytes);
		return s;
	}
	
	public static byte[] hexStringToByteArray(String hex) {
		byte[] decode = Base64.getDecoder().decode(hex);
		return decode;
	}
	
}
