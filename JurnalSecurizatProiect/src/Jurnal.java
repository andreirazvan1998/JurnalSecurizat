
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Jurnal implements  Cloneable{
	
	protected int usrId;
	protected int jurnalId;
	protected String nume;
	protected String continut;

	
	public Jurnal(int usrId,int jurnalId,String nume, String continut) {
		this.usrId=usrId;
		this.jurnalId=jurnalId;
		this.nume=nume;
		this.continut=continut;
	}
	
	public Jurnal(int usrId,int jurnalId, String continut) {
		this.usrId=usrId;
		this.jurnalId=jurnalId;
		this.nume=nume;
		this.continut=continut;
	}
	
	
	public Jurnal(int usrId,String nume, String continut) {
		this.usrId=usrId;
		this.nume=nume;
		this.continut=continut;
	}
	
	public static void addJurnal(String nume, String continut,int usrId) throws Exception {
		PreparedStatement ps;	
		byte[] byteSalt=Encripting.GnerateSalt();
	
		String prepareContinut=Cheie.encrypt(continut, byteSalt);
		try {
				 String sql="INSERT INTO jurnal(id_user,nume_jurnal,continut,salt) VALUE (?,?,?,?)";
				 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
				 ps.setLong(1, usrId);
				 ps.setString(2, nume);
				 ps.setString(3, prepareContinut);
				 ps.setString(4, Encripting.bytesToHex(byteSalt));
				 ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static ArrayList<Jurnal> getJurnale(){
		ArrayList<Jurnal> jurnale=new ArrayList<Jurnal>();
		PreparedStatement ps;
		try {
			String sql="SELECT * FROM jurnal ";
			 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
		//	ps.setLong(1, id);
			ResultSet result=ps.executeQuery();
			while(result.next()) {
				
				String saltt;
				saltt=result.getString("salt");
				int usr_id;
				usr_id=result.getInt("id_user");
				int jurnal_id;
				jurnal_id=result.getInt("id_jurnal");
				String nume;
				nume=result.getString("nume_jurnal");
				String continut;
				continut=Cheie.decrypt(result.getString("continut"), Encripting.hexStringToByteArray(result.getString("salt")));
				Jurnal j=new Jurnal(usr_id,jurnal_id,nume,continut);
				//Main.logger.info("jurnal incarcat: "+j.toString());
				jurnale.add(j);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jurnale;
	}
	
/**	public static ArrayList<Jurnal> getJurnale(int id){
		ArrayList<Jurnal> jurnale=new ArrayList<Jurnal>();
		PreparedStatement ps;
		try {
			String sql="SELECT * FROM jurnal where id_user=? ";
			 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
			 ps.setLong(1, id );
			ResultSet result=ps.executeQuery();
			while(result.next()) {
				String nume;
				nume=result.getString("nume_jurnal");
				String continut;
				continut=result.getString("continut");
				Jurnal j=new Jurnal(nume,continut);
				Main.logger.info("jurnal incarcat: "+j.toString());
				jurnale.add(j);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jurnale;
	}**/
	
	public void stergeJurnal(int jurnalId) {
		PreparedStatement ps;
		try{
			 String sql="DELETE FROM jurnal WHERE id_jurnal=?";
			 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
			 ps.setLong(1, jurnalId);
			 ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void modificareJurnal(int userId,int jurnalId,String continutNou) throws Exception {
		PreparedStatement ps;
		byte[] byteSalt=Encripting.GnerateSalt();
		String prepareContinut=Cheie.encrypt(continutNou, byteSalt);
		try {
			 String sql="UPDATE `jurnal` SET `continut`=?,salt=? WHERE id_jurnal=? AND id_user=?";
			 ps=DbConnect.getInstance().getConnexiune().prepareStatement(sql);
			 ps.setString(1,prepareContinut);
			 ps.setString(2,Encripting.bytesToHex(byteSalt));
			 ps.setLong(3, jurnalId);
			 ps.setLong(4, userId);
			 ps.execute();
			 Main.logger.info("junral modificat cu succes");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Jurnal){
			Jurnal j=(Jurnal)o;
			if(this.nume==j.getNume()&& this.continut==j.getContinut())
				return true;
			else
				return false;
		}
		return false;
	}
	
	public String toString() {
		return "id"+this.jurnalId+" jurnal: "+this.nume+"    continut: "+this.continut;
	}
	
	public void setJurnalId(int jurnalid) {
		this.jurnalId=jurnalid;
	}
	
	public int getJurnalId() {
		return jurnalId;
	}
	
	public void setId(int id) {
		this.usrId=id;
	}
	
	public int getUsrId() {
		return usrId;
	}
	
	public String getNume() {
		return nume;
	}
	
	public String getContinut() {
		return continut;
	}
	
	public void setNume(String nume) {
		this.nume=nume;
	}
	
	public void setContinut(String continut) {
		this.continut=continut;
	}
	
	
	
}
