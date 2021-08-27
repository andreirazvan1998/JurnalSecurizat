import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class User {
	protected String username;
	protected String password;
	
	
	public User(String username,String password) {
		
		this.username=username;
		this.password=password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public static boolean getValid(String username,String password) throws IOException, NoSuchAlgorithmException, SQLException {
		 PreparedStatement ps;	
		try {
				 String sql="SELECT salt,password FROM users WHERE username= ?";
				 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
				 ps.setString(1,username);
				 ResultSet result=ps.executeQuery();
				  if(result.next())
		            {
					  byte[] byteSalt=Encripting.hexStringToByteArray(result.getString(1));
					  byte[] loginPass=Encripting.Hashing(password, byteSalt);
					  byte[] storedPass=Encripting.hexStringToByteArray(result.getString(2));
					  boolean res=Arrays.equals(loginPass, storedPass);
				/**	  System.out.println(Arrays.toString(byteSalt));
					  System.out.println(Encripting.bytesToHex(loginPass));
					  System.out.println(Arrays.toString(storedPass)); **/
					  if(res) {
						  Main.logger.info("logare reusita");
						  return true;
					  }
					 
		            }
		}catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println("Datele sunt incorecte");
		return false;
	
		 
	}
	
	public static boolean duplicate(String username)throws NoSuchAlgorithmException {
		PreparedStatement forUSR;
		try {
			String forUsr="SELECT username FROM users WHERE username= ?";
			 forUSR=DbConnect.getInstance().getConnexiune().prepareStatement(forUsr);
			 forUSR.setString(1, username);
			 ResultSet result=forUSR.executeQuery();
			 if(result.next())
	            {
				
				 String str=result.getString(1);
				 System.out.println(str);
				 if(str != null && !str.trim().isEmpty()) {
					 
					 return false;
				 }
	            }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	

	public static int usrId(String username) {
		
		
		PreparedStatement ps;
		try {
			String sql="SELECT ID FROM USERS WHERE username=?";
			 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
			 ps.setString(1, username);
			 ResultSet result=ps.executeQuery();
			 if(result.next())
				 return result.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static void register(String username,String password) throws NoSuchAlgorithmException {
			PreparedStatement ps;	
			byte[] byteSalt=null;
			byteSalt=Encripting.GnerateSalt();
			byte[] pass=Encripting.Hashing(password,byteSalt);
			String passToHex=Encripting.bytesToHex(pass);
			String saltToHex=Encripting.bytesToHex(byteSalt);
			
			try {
					 String sql="INSERT INTO users(username,password,salt) VALUE (?,?,?)";
					 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
					 ps.setString(1, username);
					 ps.setString(2, passToHex);
					 ps.setString(3, saltToHex);
					 if(duplicate(username)) {
						 ps.executeUpdate();
					 	 Main.logger.info("Inserare user reusita!!");}
					 else
						 Main.logger.info("Username-ul este deja luat!");
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
}
