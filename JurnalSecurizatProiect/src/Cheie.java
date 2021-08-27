import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Cheie {
	
	protected final static String ALGORITHM="AES";
		
	public static String encrypt(String strToEncrypt,byte[] salt) {
	    try {
	      IvParameterSpec iv = new IvParameterSpec(salt);
	      String SaltToString=Encripting.bytesToHex(salt);
	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	      KeySpec spec = new PBEKeySpec(SaltToString.toCharArray(), salt, 65536, 256);
	      SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHM);
	 
	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
	      return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
	    } catch (Exception e) {
	      System.out.println("eroare la criptare " + e.toString());
	    }
	    return null;
	  }
	
	public static String decrypt(String strToDecrypt, byte[] salt) {
	    try {
	      IvParameterSpec iv = new IvParameterSpec(salt);
	      String SaltToString=Encripting.bytesToHex(salt);
	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	      KeySpec spec = new PBEKeySpec(SaltToString.toCharArray(), salt, 65536, 256);
	      SecretKeySpec secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), ALGORITHM);
	 
	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	      cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
	      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } catch (Exception e) {
	      System.out.println("eroare la decryptare " + e.toString());
	    }
	    return null;
	  }
	

}
