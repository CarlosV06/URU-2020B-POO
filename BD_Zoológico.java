package bd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

import javax.swing.JFrame;

public class BD_Zoológico {
//ATRIBUTOS
	private static BD_Zoológico BD = new BD_Zoológico();
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String dbName = "ZoológicoBD"; 
	private String DriverBD = "org.postgresql.Driver";
	private String urlDB = "jdbc:postgresql://localhost:5432/" + this.dbName;
	private String userDB = "postgres";
	private String passDB = "Carlos151201"; 
	
	
	//CONSTRUCTOR
	private BD_Zoológico(){
		try {
		Class.forName(DriverBD);
		this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
		MiServer sr = new MiServer();
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		} 
	
	public static BD_Zoológico getInstances() {
		return BD;
		} 
	//MÉTODO PARA VISUALIZAR LOS ELEMENTOS DE LA BASE DE DATOS (ANIMALES).
	public String dbStatement(String query) {
		String ID = null;
		try {
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(query);
		while(rs.next()) {
		ID += "ID:"+rs.getString("IDAnimal")+"Clase:" +(rs.getString("AClase"))+"Tipo:"+rs.getString("ATipo")+"Peso:"+rs.getString("APeso")+ "Tamaño:"+rs.getString("ATamaño")+"Color:"+rs.getString("AColor")+"\n";
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
	
	//MÉTODO PARA AGREGAR ELEMENTOS A LA BASE DE DATOS (EN ESTE CASO ANIMALES A LA BD DEL ZOOLÓGICO).
	public void dbPrepareStatement(String query, Object[] obj) {
		try {
		this.pstmt = this.conn.prepareStatement("insert into SistemaZoológico values (?, ?, ?, ?, ?, ?)");
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
	
	
	//MÉTODO PARA CERRAR LA CONEXIÓN
	public void dbClose() {
		try {
		this.conn.close();
		System.out.println("Conexion cerrada");
		} catch (SQLException e) {
		e.printStackTrace();
		}
		} 
	
	//MÉTODO PARA ELIMINAR UN ANIMAL
	public void EliminarA(String query, Object IDa) {
		try {
			this.pstmt = this.conn.prepareStatement("DELETE FROM SistemaZoológico WHERE IDAnimal = ? ");
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
	
	
//MÉTODO PARA MODIFICAR UN ANIMAL
	public void ModificarA(String[] obj) {
		
		try {
			this.pstmt = this.conn.prepareStatement("UPDATE SistemaZoológico SET APeso = ? , ATamaño = ? , AColor = ? WHERE IDAnimal = ? ");
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
	
	
//CREACIÓN DELSERVIDOR PARA EL ZOOLÓGICO QUE SE EJECUTARÁ CADA VEZ QUE SE INICIE SU APP
	class MiServer extends JFrame implements Runnable{
		
		public MiServer(){
			
			setSize(300, 300);
			
			setTitle("Servidor para su Zoológico");
			
			setVisible(true);
			
			Thread Hilo = new Thread(this);
			Hilo.start();
		}
		
		
		@Override
		public void run() {
			try {
				
				ServerSocket Servidor = new ServerSocket(6000);
				 while(true) {
				 Socket Socket = Servidor.accept();
				 System.out.println("Conectado a:"+Socket.getRemoteSocketAddress().toString()+"Ahora mismo.");
				 DataInputStream o = new DataInputStream(Socket.getInputStream());
				 String MensajeLei = o.readUTF();

				
				 if (MensajeLei.equals("VerAnimales")) {
					 BD_Zoológico BD =  BD_Zoológico.getInstances();
					 String Elementos=(BD.dbStatement("SELECT*FROM SistemaZoológico"));
					 DataOutputStream Pal = new DataOutputStream(Socket.getOutputStream());
					 Pal.writeUTF(Elementos);
				
					 
				 } if (MensajeLei.equals("Menu")) {
	//DAMOS RESPUESTA INDICANDO EL TIPO DE ANIMAL (CANINO, FELINO O PRIMATE):
					 String Respuesta = "1: Modo Oscuro\n2: Modo Claro";
					 DataOutputStream Pal = new DataOutputStream(Socket.getOutputStream());
					 Pal.writeUTF(Respuesta);
					 
					 } 
				if (MensajeLei.equals("1")) {
					String Respuesta = "1";
					DataOutputStream Pal = new DataOutputStream(Socket.getOutputStream());
					Pal.writeUTF(Respuesta);
				}
				else {
					String Respuesta ="2";
					DataOutputStream Pal = new DataOutputStream(Socket.getOutputStream());
					Pal.writeUTF(Respuesta);
					
				}
				 
				 
				 
				 
				}
				 
				 
				 		
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
}//FIN CLASE BD
