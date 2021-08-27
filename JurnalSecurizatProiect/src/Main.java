import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	public static Logger logger=Logger.getAnonymousLogger();
				 
	public static void main(String... args) throws Exception {
		// TODO Auto-generated method stub
		//get();
		//User.getValid("name2","12345");
	//	Validation.register("name2", "12345");
		//System.out.println(v.duplicate("name2"));
		//Jurnal.addJurnal("jurnal1", "ceva secret", 1);
	/**	
		try {
			KeyGenerator k=KeyGenerator.getInstance("AES");
			System.out.println(k);
			Cipher c=Cipher.getInstance("AES");
		/**	byte[] encryptedData=Cheie.encrypt("ana are mere",k,c);
			String encriptString=new String(encryptedData);
			System.out.println(encriptString);
			
			String decrypt=Cheie.decrypt(encryptedData,k,c);
			System.out.println(decrypt);
		Jurnal.modificareJurnal(1, "ceva secret si nou");
		System.out.println(Jurnal.getJurnale().toString()); **/
		
		//DbConnect.getInstance().getConnexiune();
		
		Interfata in=new Interfata();
	}
}
