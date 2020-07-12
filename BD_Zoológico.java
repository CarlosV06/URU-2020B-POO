package bd;

import java.sql.*;

public class BD_Zool�gico {
//ATRIBUTOS
	private static BD_Zool�gico BD = new BD_Zool�gico();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String dbName = "Zool�gicoBD"; 
	private String DriverBD = "org.postgresql.Driver";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "Carlos151201"; 
	
	
	//CONSTRUCTOR
	private BD_Zool�gico(){
		try {
		Class.forName(DriverBD);
		this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
		System.out.println("Conexion establecida");
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		} 
	
	public static BD_Zool�gico getInstances() {
		return BD;
		} 
	//M�TODO PARA VISUALIZAR LOS ELEMENTOS DE LA BASE DE DATOS (ANIMALES).
	public String dbStatement(String query) {
		String ID = null;
		try {
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(query);
		while(rs.next()) {
		ID += "ID:"+rs.getString("IDAnimal")+"Clase:" +(rs.getString("AClase"))+"Tipo:"+rs.getString("ATipo")+"Peso:"+rs.getString("APeso")+ "Tama�o:"+rs.getString("ATama�o")+"Color:"+rs.getString("AColor")+"\n";
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
	
	//M�TODO PARA AGREGAR ELEMENTOS A LA BASE DE DATOS (EN ESTE CASO ANIMALES A LA BD DEL ZOOL�GICO).
	public void dbPrepareStatement(String query, Object[] obj) {
		try {
		this.pstmt = this.conn.prepareStatement("insert into SistemaZool�gico values (?, ?, ?, ?, ?, ?)");
		this.pstmt.setLong(1, (int) obj[0]);
		this.pstmt.setString(2, (String) obj[1]);
		this.pstmt.setString(3, (String) obj[2]);
		this.pstmt.setFloat(4, (float) obj[3]);
		this.pstmt.setFloat(5, (float) obj[4]);
		this.pstmt.setString(6, (String) obj[5]);
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
	
	
	//M�TODO PARA CERRAR LA CONEXI�N
	public void dbClose() {
		try {
		this.conn.close();
		System.out.println("Conexion cerrada");
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} 
	
	//M�TODO PARA ELIMINAR UN ANIMAL
	public void EliminarA(String query, Object IDa) {
		try {
			this.pstmt = this.conn.prepareStatement("DELETE FROM SistemaZool�gico WHERE IDAnimal = ? ");
			this.pstmt.setLong(1, (int) IDa);
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
	
	
//M�TODO PARA MODIFICAR UN ANIMAL
	public void ModificarA(String[] obj) {
		
		try {
			this.pstmt = this.conn.prepareStatement("UPDATE SistemaZool�gico SET APeso = ? , ATama�o = ? , AColor = ? WHERE IDAnimal = ? ");
			this.pstmt.setFloat(1, Float.parseFloat(obj[0]));
			this.pstmt.setFloat(2, Float.parseFloat(obj[1]));
			this.pstmt.setString(3, (String) obj[2]);
			this.pstmt.setLong(4, Integer.parseInt(obj[3]));
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
	
	
	
	
	
	
	
}//FIN CLASE BD
