package base_de_datos;
import java.sql.*;




public class BDCalculadora {
	private static BDCalculadora BD = new BDCalculadora();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String dbName = "CalculadoraBD"; 
	private String DriverBD = "org.postgresql.Driver";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "Carlos151201"; 
	
	
	public BDCalculadora() {
		try {
			Class.forName(DriverBD);
			this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
			System.out.println("Conectado");
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			}
			}
	
	
public static BDCalculadora getInstances() {
	return BD;
	}


public String dbStatement(String query) {
	String ID ="";
	try {
	this.stmt = this.conn.createStatement();
	this.rs = this.stmt.executeQuery(query);
	while(rs.next()) {
	ID += "ID:"+rs.getString("ID")+"\nIPv4:" +(rs.getString("IPv4"))+"\nIPv6:"+rs.getString("IPv6")+"\nClase"+rs.getString("Clase")+"\n";
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}finally {
	try {
	this.stmt.close();
	this.rs.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return ID;
	}
	
	
	
public void dbPrepareStatement(String query, Object[] obj) {
	try {
	this.pstmt = this.conn.prepareStatement("insert into BDIP values (?, ?, ?, ?)");
	this.pstmt.setLong(1, (int) obj[0]);
	this.pstmt.setString(2, (String) obj[1]);
	this.pstmt.setString(3, (String) obj[2]);
	this.pstmt.setString(4, (String) obj[3]);
	this.pstmt.executeUpdate();
	} catch (SQLException e) {
	e.printStackTrace();
	} finally {
	try {
	this.pstmt.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	 }
	}
	
	
	
	
	
	
	
	
	
	
	

	
//MÉTODO PARA OPTENER EL ID MÁXIMO:
public int IDMAX() {
int ID=1;
try {
	this.stmt = this.conn.createStatement();
	this.rs = this.stmt.executeQuery("SELECT MAX(ID) FROM BDIP");
	while (rs.next()) {
		ID = rs.getInt(1)+1;
	}
	
}catch (Exception e) {
	System.out.println(e);
}finally {
	try {
		this.stmt.close();
		this.rs.close();
	}catch (Exception p) {
		
	}
}	
	return ID;
}















	
}
