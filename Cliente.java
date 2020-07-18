package bd;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.*;
import java.net.Socket;
import java.net.UnknownHostException;




public class Cliente{
	public static void main(String Args[]) {
		Ventana o = new Ventana();
		o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



class Ventana extends JFrame{
	
	public Ventana() {
		
		setSize(600, 600);
		
		setBackground(Color.LIGHT_GRAY);
		
		setTitle("Aplicación para su cliente");
		
		Chat o = new Chat();
		
		add(o);
		
		setVisible(true);
		
	}
	
	
	
	
}




class Chat extends JPanel{
	private JTextField Mensaje;
	private JButton Enviar;
	private JTextArea Mensajeria;
	public Chat() {
		setSize(800, 800);
		this.Mensajeria = new JTextArea(20, 50);
		add(Mensajeria);
		this.Mensaje = new JTextField(30);
		add(Mensaje);
		this.Enviar = new JButton("Enviar");
		add(Enviar);
		
		
		//EVENTO PARA COMUNICAR CON EL SERVIDOR
		Enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//SE CREA EL SOCKET CON LA DIRECCIÓN IP Y EL PUERTO:
					Socket Socket = new Socket("192.168.1.145",6000);
					//SE ENVÍA EL MENSAJE AL SERVIDOR:
					DataOutputStream Salida = new DataOutputStream(Socket.getOutputStream());
					Salida.writeUTF(Mensaje.getText());
					//SE RECIBE LA RESPUESTA DEL SERVIDOR:
					DataInputStream Entrada = new DataInputStream(Socket.getInputStream());
					String Resp = Entrada.readUTF();
					//SE DAN DIVERSAS OPCIONES PARA EL USUARIO:
					if (Resp.equals("1")) {
						setBackground(Color.darkGray);
					}
					if (Resp.equals("2")) {
						setBackground(Color.lightGray);
					}
					Mensajeria.setText(Mensaje.getText()+"\n"+Resp);
					Socket.close();
					
				} catch (UnknownHostException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				} catch (IOException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}