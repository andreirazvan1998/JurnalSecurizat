import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButonCreareJurnal extends JButton implements Command {

	JTextField titlu;
	JTextArea continut;

	public ButonCreareJurnal(JTextField titlu, JTextArea continut) {
		this.titlu=titlu;
		this.continut=continut;
	}


	@Override
	public void execute() {
		String titluJurnal=titlu.getText();
		String continutJurnal=continut.getText();
		ButonLogin bt=new ButonLogin();
		int id=ButonLogin.getId();
		System.out.println(id);
		
		try {
			if(!(titluJurnal.isEmpty())) {
				if(id==0) {
					Main.logger.info("userul este invalid, te rog sa te loghezi intai");
				}else {
					Jurnal j=new Jurnal(id,titluJurnal,continutJurnal);
					Repozitory.getInstance().addJurnal(j);
					Main.logger.info("jurnalul a fost introdus cu succes");
				}
			}else
				Main.logger.info("jurnalul trebuie sa aiba un titlu");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
