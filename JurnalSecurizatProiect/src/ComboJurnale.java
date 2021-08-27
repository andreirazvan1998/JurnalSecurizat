import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class ComboJurnale extends JComboBox<String> implements Command,Observator {

	static String[] jurnalee;
	protected JTextArea descriere;

	public ComboJurnale(JTextArea descriere) {
		this.descriere=descriere;
		Repozitory.getInstance().addObservator(this);

	}

	@Override
	public void execute() {
		String elementAles=(String) this.getSelectedItem();
		if(elementAles!=null) {
			elementAles=elementAles.strip();	
			for(Jurnal j:Repozitory.getInstance().getJurnale()) {
				if(elementAles.equals(j.getNume())) {
					descriere.setText(j.getContinut());
					Repozitory.getInstance().setJurnalId(j.getJurnalId());
					Main.logger.info("id-ul jurnalului este"+Repozitory.getInstance().getJurnalId());
					break;

				}
			}
		}
	}

	public void update() {

		ArrayList<String> jurnaleee=new ArrayList<String>();

		for(int i=0;i<Repozitory.getInstance().getJurnale().size();i++){
			if(Repozitory.getInstance().getJurnale().get(i).getUsrId()==Repozitory.getInstance().getId()) {
				jurnaleee.add(Repozitory.getInstance().getJurnale().get(i).getNume());
			}
		}

		for(int i=this.getItemCount()-1;i>=0;i--){
			this.removeItemAt(i);
		}
		Main.logger.info("mesaj din update");
		for(String d: jurnaleee) {
			this.addItem(d);
		} 
	}


}











