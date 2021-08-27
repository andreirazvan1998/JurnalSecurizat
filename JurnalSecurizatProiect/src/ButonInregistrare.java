import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ButonInregistrare extends JButton implements Command {
	 JTextField nume;
	 JPasswordField parola;
	 JPasswordField repetaParola;
	 
	 public ButonInregistrare(JTextField nume,JPasswordField parola, JPasswordField repetaParola)
	 {
		 this.nume=nume;
		 this.parola=parola; 
		 this.repetaParola=repetaParola;
	 }

	@Override
	public void execute() {
		 String numeUser=nume.getText();
		 char[] parolaUser=parola.getPassword();
		 char[] repetaparolaUsr=repetaParola.getPassword();
		 if(String.valueOf(parolaUser).compareTo(String.valueOf(repetaparolaUsr))==0){
			 if(!(numeUser.isEmpty()||String.valueOf(parolaUser).isEmpty()||String.valueOf(repetaparolaUsr).isEmpty())){
			 try {
				User.register(numeUser, String.valueOf(repetaparolaUsr));
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }else
			 Main.logger.info("unul din campuri a fost lasat liber");
		}else {
			Main.logger.info("parolele nu coincid");
		}
		
	}
	
	

}
