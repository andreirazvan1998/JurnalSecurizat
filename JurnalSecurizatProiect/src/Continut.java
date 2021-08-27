import java.util.ArrayList;

import javax.swing.JTextArea;

public class Continut extends JTextArea implements Observator {
	
	private ComboJurnale combo;
	
	public Continut( ComboJurnale combo) {
		super(50,50);
		
		this.combo=combo;
		Repozitory.getInstance().addObservator(this);
	}
	
	
	
	@Override
	public void update() {
		
		String titlu=combo.getSelectedItem().toString().trim();
		for(int i=0; i<Repozitory.getInstance().getJurnale().size();i++)
		{
			if(Repozitory.getInstance().getJurnale().get(i).getNume().equals(titlu)) {
				this.setText(Repozitory.getInstance().getJurnale().get(i).getContinut());
				break;
			}
		}
		//this.update(this.getGraphics());
		Main.logger.info("update continut");
	}
	

}
