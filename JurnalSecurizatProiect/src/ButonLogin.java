import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ButonLogin extends JButton implements Command {

	 JTextField nume;
	 JPasswordField parola;
	 public static int id;
	
	 public ButonLogin(JTextField nume,JPasswordField parola) {
		 this.nume=nume;
		 this.parola=parola; 
	 }
	 
	 public ButonLogin() {
		 
	 }
	 public void setId(int id) {
			ButonLogin.id=id;
		}
		public static int getId() {
			return id;
		}
		
		
	
	@Override
	public void execute(){
		 String numeUser=nume.getText();
		 char[] myChar=parola.getPassword();
		
		 try {
			if (User.getValid(numeUser, String.valueOf(myChar))){
				setId(User.usrId(numeUser));
				Repozitory.getInstance().setId(User.usrId(numeUser));
				Main.logger.info("id setat in repozitory"+Repozitory.getInstance().getId());
				Repozitory.getInstance().notifyAllOb();
				System.out.println(getId());
				
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	 }
	
	
	 
}
