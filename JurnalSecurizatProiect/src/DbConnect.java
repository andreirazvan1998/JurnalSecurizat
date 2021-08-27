
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	protected String user="root";
	protected String pass="";
	protected Connection conexiune=null; 
	
	private static DbConnect single_instance=null;
	private DbConnect() {
		try {
			this.conexiune=DriverManager.getConnection("jdbc:mysql://localhost:3306/test2",user,pass);
			if(conexiune!=null)
				Main.logger.info("Conexiune reusita!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnexiune() {
		return conexiune;
	}
	public static DbConnect getInstance()
	{
		if(single_instance == null)
			single_instance=new DbConnect();
		return single_instance;
	}
	
	
}
