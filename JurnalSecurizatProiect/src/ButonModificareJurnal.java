import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButonModificareJurnal extends JButton implements Command {
	
	ComboJurnale comboJurnale;
	JTextArea textDescriere;
	
	public ButonModificareJurnal(ComboJurnale comboJurnale,JTextArea textDescriere) {
		super("Modificare Jurnal");
		this.comboJurnale=comboJurnale;
		this.textDescriere=textDescriere;
	}

	

	@Override
	public void execute() {
		
		int id=Repozitory.getInstance().getId();
		int jurnalid=Repozitory.getInstance().getJurnalId();
		String descriere=textDescriere.getText();
		Jurnal j=new Jurnal(id,jurnalid,descriere);
		try {
			if(id==0) {
				Main.logger.info("trebuie sa te loghezi intai!");
				
			}
			else {
				Repozitory.getInstance().updateJurnal(j);
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
