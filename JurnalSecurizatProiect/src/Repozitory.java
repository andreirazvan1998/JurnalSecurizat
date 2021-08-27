import java.util.ArrayList;

public class Repozitory implements Subject  {
	
	{
		Main.logger.info("************* Incarcare date");
	}
	
	int jurnalId;
	int id;
	protected ArrayList<Jurnal>jurnale=Jurnal.getJurnale();

	{
		Main.logger.info("************* Incarcare date realizata!");
	}
	private static Repozitory instanta=null;
	private ArrayList<Observator> observatori=new ArrayList<Observator> ();
	
	private Repozitory(){	
			
		}
	
	public static Repozitory getInstance(){
		if(instanta==null)
			instanta=new Repozitory();
		return instanta;
	}

	public void notifyAllOb() {
		for(int i=0;i<observatori.size();i++){
			observatori.get(i).update();
		}
	}

	public void addObservator(Observator obs) {
		observatori.add(obs);
		
	}

	
	public void remmoveObservator(Observator obs) {
		observatori.remove(obs);
	}
	
	public void addJurnal(Jurnal j) throws Exception {
		jurnale.add(j);
		Jurnal.addJurnal(j.nume, j.continut, id);
		notifyAllOb();

	}
	
	public void updateJurnal(Jurnal j) throws Exception {
		for(int i=0;i<jurnale.size();i++) {
			if(jurnale.get(i).jurnalId==j.jurnalId) {
				jurnale.get(i).continut=j.continut;
				break;
			}
			
		}
		Jurnal.modificareJurnal(id,jurnalId, j.continut);
		notifyAllOb();
		Main.logger.info("notifica observatorii");
	}
	
	
	public void setJurnale(ArrayList<Jurnal>jurnale) {
		this.jurnale=jurnale;
		notifyAllOb();
	}
	
	
	public ArrayList<Jurnal> getJurnale(){
		return jurnale;
	}
	
	public void setJurnalId(int jurnalidd) {
		this.jurnalId=jurnalidd;
		notifyAllOb();
	}
	
	public int getJurnalId() {
		return jurnalId;
	}
	
	
	public  void setId(int idd) {
		id=idd;
		notifyAllOb();
	}
	
	public  int getId() {
		return id;
	}
	
}
