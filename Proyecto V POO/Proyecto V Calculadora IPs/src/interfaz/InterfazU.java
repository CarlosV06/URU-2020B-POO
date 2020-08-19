package interfaz;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import javax.swing.*;
import base_de_datos.BDCalculadora;




public class InterfazU extends JFrame {
private JPanel menú;
//CONSTRUCTOR PARA LA VENTANA DE LA CALCULADORA
	public InterfazU() {
		setSize(800, 800);
		setTitle("Calculadora de IP´s");
		this.menú = new JPanel();
		add(menú);
		menú.setLayout(null);
		menú.setBackground(Color.DARK_GRAY);
		JButton Calcular = new JButton("IPv4");
		Calcular.setBounds(150, 90, 100, 50);
		menú.add(Calcular);
		JButton Mostrar = new JButton("Mostrar");
		Mostrar.setBounds(150, 150, 100, 50);
		menú.add(Mostrar);
		JButton Menú = new JButton("Menú");
		Menú.setBounds(90, 210, 100, 50);
		menú.add(Menú);
		JButton IPv6 = new JButton("IPv6");
		IPv6.setBounds(150, 215, 100, 50);
		menú.add(IPv6);
		JButton IPv4H = new JButton("Cal IPv4 con hosts");
		IPv4H.setBounds(100, 30, 200, 50);
		menú.add(IPv4H);
		JButton I = new JButton("¿?");
		I.setBounds(120, 300, 100, 50);
		menú.add(I);
		Menú.setVisible(false);
		
		Calcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			Calcular o = new Calcular();
			setContentPane(o);
			add(Menú);
			Menú.setVisible(true);
			validate();
			invalidate();
			}
		});
		
		Mostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Mostrar o = new Mostrar();
				setContentPane(o);
				add(Menú);
				Menú.setVisible(true);
				validate();
				invalidate();
				
			}
			
		});
		
		
		
		
		
		Menú.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setContentPane(menú);	
			}
		});
		
		IPv6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				IPv6 o = new IPv6();
				setContentPane(o);
				add(Menú);
				Menú.setVisible(true);
				validate();
				invalidate();
				
			}
			
		});
		
		IPv4H.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HIP o = new HIP();
				setContentPane(o);
				add(Menú);
				Menú.setVisible(true);
				validate();
				invalidate();
				
			}
			
		});
		
		I.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				A o = new A();
				setContentPane(o);
				add(Menú);
				Menú.setVisible(true);
				validate();
				invalidate();
				
				
				
			}
			
		});
		
		
		setVisible(true);
		
	}
}

//VISTA PARA EL BOTÓN CALCULAR
class Calcular extends JPanel {	
	BDCalculadora BD = BDCalculadora.getInstances();
	//CONSTRUCTOR
	public Calcular() {
		setLayout(null);
		setSize(400, 400);
		setBackground(Color.DARK_GRAY);
		JTextArea o = new JTextArea();
		o.setBounds(70, 15, 250, 180);
		add(o);
		JLabel IIP = new JLabel("IP: ");
		IIP.setBounds(60, 230, 100, 100);
		JTextField OctetoA = new JTextField();
		OctetoA.setBounds(90, 270, 50, 20);
		JTextField OctetoB = new JTextField();
		OctetoB.setBounds(155, 270, 50, 20);
		JTextField OctetoC = new JTextField();
		OctetoC.setBounds(220, 270, 50, 20);
		JTextField OctetoD = new JTextField();
		OctetoD.setBounds(280, 270, 50, 20);
		JLabel IM = new JLabel("Máscara:");
		IM.setBounds(30, 260, 100, 100);
		JTextField MA = new JTextField();
		MA.setBounds(90, 300, 50, 20);
		JTextField MB = new JTextField();
		MB.setBounds(155, 300, 50, 20);
		JTextField MC = new JTextField();
		MC.setBounds(220, 300, 50, 20);
		JTextField MD = new JTextField();
		MD.setBounds(280, 300, 50, 20);
		
		JButton C = new JButton("Calcular");
		C.setBounds(210, 210, 100, 50);
		add(IIP);
		add(OctetoA);
		add(OctetoB);
		add(OctetoC);
		add(OctetoD);
		add(IM);
		add(MA);
		add(MB);
		add(MC);
		add(MD);
		add(C);
		//EVENTO PARA EL BOTÓN CALCULAR:
		C.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//EVALUACIÓN PARA VERIFICAR TIPO DE IP
				
				int A = Integer.parseInt(OctetoA.getText());
				int B = Integer.parseInt(OctetoB.getText());
				int C = Integer.parseInt(OctetoC.getText());
				int D = Integer.parseInt(OctetoD.getText());
				String IP = OctetoA.getText()+"."+OctetoB.getText()+"."+OctetoC.getText()+"."+OctetoD.getText();
				int mA = Integer.parseInt(MA.getText());
				int mB = Integer.parseInt(MB.getText());
				int mC = Integer.parseInt(MC.getText());
				int mD = Integer.parseInt(MD.getText());
				String Ma = MA.getText()+"."+MB.getText()+"."+MC.getText()+"."+MD.getText();
			
				//INSTANCIA PARA UTILIZAR LOS MÉTODOS:
				F p = new F();
				//VERIFICACIÓN DE CLASE Y TIPO DE IP.
				//VERIFICACIÓN PARA RED RESERVADA:
				if (A==0) {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String ClaseA = "IP Pública de clase A."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Software.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast:"+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseA);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseA};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
			
				//IP PÚBLICA/PRIVADA DE CLASE A.
				if (A>0 && A<=126) {
					//VERIFICACIÓN PARA RED PRIVADA
					if (A==10) {
						if (B>=0 && B<=255) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String ClaseA = "IP Privada de Clase A."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP:  "+IP+"\n"+ClaseA);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseA};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}
					}else if (A==100) {
							if (B>=64&&B<127) {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String ClaseA = "IP Pública de Clase A."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseA);
							}else if (B==255&&C==255&&D==255) {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String 	ClaseA = "IP Pública de Clase A."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red:"+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+"\nIP Broadcast."+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseA);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseA};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}
							else {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String	ClaseA = "IP Pública de Clase A."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP:  "+IP+"\n"+ClaseA);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseA};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}

						}
						else {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String	ClaseA = "IP Pública de Clase A."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red:"+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP:  "+IP+"\n"+ClaseA);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseA};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
				}//FIN VERIFICACIÓN DE IP/CLASE A.
				
				//IP PÚBLICA/PRIVADA DE CLASE B.
				if (A>126 && A<=191) {
					//VERIFICACIÓN PARA RED PRIVADA.
					if (A==172) {
						if (B>=16 && B<=31) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String ClaseB = "IP Privada de Clase B."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red Privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseB);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}else {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String ClaseB = "IP Pública de Clase B."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseB);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}
		
					}else if (A==127) {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String ClaseB = "IP Pública de Clase B."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Host.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP:  "+IP+"\n"+ClaseB);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
					//VERIFICACIÓN PROTOCOLO APIPA.	
					else if (A==169 && B==254) {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String ClaseB = "IP Privada de Clase B."+"\nPertenece al protocolo APIPA.\nIP Reservada para: Subred.\nMáscara de red:"+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nIP Unicast."+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseB);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (C==255&&D==255){
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String 	ClaseB = "IP Pública de Clase B."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nIP Broadcast."+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseB);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
					else {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String ClaseB = "IP Pública de Clase B."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseB);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseB};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					
					}
					
				}//FIN VERIFICACIÓN IP PÚBLICA/PRIVADA DE CLASE B.
				
				//IP PÚBLICA/PRIVADA DE CLASE C.
				if (A>=192 && A<=223) {
					//VERIFICACIÓN DE RED PRIVADA
					if (A==192) {
						if (B==168 && C==0) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String 	ClaseC = "IP Privada de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red Privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseC);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}else if (B==0&&C==0) {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red Privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseC);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}else if (B==0&&C==2) {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Documentación.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseC);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
								
							}else if (B==88&&C==99) {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Intenet.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseC);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}else {
								p.DRCal(A, B, C, D, mA, mB, mC, mD);
								String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
								o.setText("Dirección IP: "+IP+"\n"+ClaseC);
								Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
								BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
							}
					}else if (A==198) {
						if (B==18) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Red Privada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseC);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}else if (B==51&&C==100) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Documentación.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseC);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}
					}else if (A==203) {
						if (B==0&&C==113) {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Documentación.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseC);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
					}else if (D==255) {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red:"+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nIP Broadcast."+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseC);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						String 	ClaseC = "IP Pública de Clase C."+"\nNo pertenece al protocolo APIPA.\nLa IP no es Reservada.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
						o.setText("Dirección IP: "+IP+"\n"+ClaseC);
						Object [] O = {BD.IDMAX() ,IP, "0", ClaseC};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
					
				}//FIN VERIFICACIÓN IP PÚBLICA/PRIVADA DE CLASE C.
				
				//IP PÚBLICA DE CLASE D.
				if(A>=224 && A<=239) {
					p.DRCal(A, B, C, D, mA, mB, mC, mD);
					String ClaseD = "IP Pública de Clase D."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Internet.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nIP Multicast."+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
					o.setText("Dirección IP: "+IP+"\n"+ClaseD);
					Object [] O = {BD.IDMAX() ,IP, "0", ClaseD};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
				// IP PÚBLICA DE CLASE E.
				if (A>=240 && A<=255) {
					if (A==255) {
						p.DRCal(A, B, C, D, mA, mB, mC, mD);
						if (B==255&&C==255&&D==255) {
							String 	ClaseE = "IP Pública de Clase E."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para: Subred\n(Destino Multidisfunción).\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseE);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseE};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}else {
							p.DRCal(A, B, C, D, mA, mB, mC, mD);
							String ClaseE = "IP Pública de Clase E."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para Internet.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
							o.setText("Dirección IP: "+IP+"\n"+ClaseE);
							Object [] O = {BD.IDMAX() ,IP, "0", ClaseE};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
						}
					
				}else {
					p.DRCal(A, B, C, D, mA, mB, mC, mD);
					String ClaseE = "IP Pública de Clase E."+"\nNo pertenece al protocolo APIPA.\nIP Reservada para Internet.\nMáscara de red: "+Ma+"\nDirección de red: "+p.getDirecciónRed()+"\nDirección de Gateway: "+p.getGateway()+"\nDirección de Broadcast: "+p.getBIP()+p.getRango();
					o.setText("Dirección IP: "+IP+"\n"+ClaseE);
					Object [] O = {BD.IDMAX() ,IP, "0", ClaseE};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
				
			}
			//LIMITADOR PARA DIGITOS DE OCTETOS:
				if (A>255||B>255||C>255||D>255||A<0||B<0||C<0||D<0||mA<0||mA>255||mB<0||mB>255||mC<0||mC>255||mD<0||mD>255) {
					String Error = "Error, IP o Máscara no valida.\nPor favor introduzca una IP o Máscara valida.";
					o.setText(Error);
				}
			} //FIN EVENTO DEL BOTÓN CALCULAR.
			
		});
		
		
		
	
		}



}

//VISTA PARA MOSTRAR
class Mostrar extends JPanel{
	BDCalculadora BD = BDCalculadora.getInstances();
	//CONSTRUCTOR
	public Mostrar() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		JTextArea o = new JTextArea();
		o.setText(BD.dbStatement("SELECT* FROM BDIP"));
		o.setBounds(200, 30, 400, 400);
		add(o);
		
	}
	
}


//FUNCIÓN PARA CALCULAR LA DIRECCIÓN DE RED:
class F {
private String DirecciónRed, GWIP, BIP,Rango;
private int o;
	//MÉTODO PARA CALCULAR LA DIRECCIÓN DE RED, GW y DIRECCIÓN BROADCAST.
public void DRCal(int OctetoA, int OctetoB, int OctetoC, int OctetoD, int A, int B, int C, int D) {
		//CALCULO DE LA DIRECCÓN DE RED:
		int DRA = OctetoA&A;
		int DRB = OctetoB&B;
		int DRC = OctetoC&C;
		int DRD = OctetoD&D;
		int DRGW = DRD+1;
		//ESCRITURA DE LA DIRECCIÓN DE RED
		String DrGW = String.valueOf(DRGW);
		String DrA = String.valueOf(DRA);	
		String DrB = String.valueOf(DRB);	
		String DrC = String.valueOf(DRC);	
		String DrD = String.valueOf(DRD);	
		this.DirecciónRed = DrA+"."+DrB+"."+DrC+"."+DrD;
		//DIRECCIÓN DE PUERTO DE RED (GATEWAY)
		this.GWIP=DrA+"."+DrB+"."+DrC+"."+DrGW;
		//DIRECCIÓN DE BROADCAST
			//INVERTIMOS LA MÁSCARA, Y POSTERIORMENTE REALIZAMOS OPERACIÓN OR CON EL OCTETO RESPECTIVO DE LA IP.
		int BA = (~A & 0xff)|OctetoA;
		int BB = (~B & 0xff)|OctetoB;
		int BC = (~C & 0xff)|OctetoC;
		int BD = (~D & 0xff)|OctetoD;
		
		
		
		//ESCRITURA DE LA DIRECCIÓN DE BROADCAST.
		String BIPA = String.valueOf(BA);
		String BIPB = String.valueOf(BB);
		String BIPC = String.valueOf(BC);
		String BIPD = String.valueOf(BD);
		this.BIP = BIPA+"."+BIPB+"."+BIPC+"."+BIPD;
		
		int bIPD = BD-1;
		String BO = String.valueOf(bIPD);
		//RANGO DE DIRECCIONES IPv4.
		
		Rango ="\nRango de direcciones:\n"+GWIP+"->"+BIPA+"."+BIPB+"."+"."+BIPC+"."+BO;
		
		
		
}
	
public String getDirecciónRed () {
	return DirecciónRed;
}
	
	
public String getGateway() {
	return GWIP;
}
	
public String getBIP() {
	return BIP;
}
public String getRango() {
	return Rango;
}
	
}
	
//Para IPv6
class IPv6 extends JPanel{
	BDCalculadora BD = BDCalculadora.getInstances();
	public IPv6() {
		setLayout(null);
		setSize(400, 400);
		setBackground(Color.DARK_GRAY);
		JTextArea o = new JTextArea();
		o.setBounds(70, 15, 250, 180);
		add(o);
		JLabel IIP = new JLabel("IP: ");
		IIP.setBounds(60, 230, 100, 100);
		JTextField GA = new JTextField();
		GA.setBounds(90, 270, 50, 20);
		JTextField GB = new JTextField();
		GB.setBounds(155, 270, 50, 20);
		JTextField GC = new JTextField();
		GC.setBounds(220, 270, 50, 20);
		JTextField GD = new JTextField();
		GD.setBounds(280, 270, 50, 20);
		JTextField GE = new JTextField();
		GE.setBounds(90, 300, 50, 20);
		JTextField GF = new JTextField();
		GF.setBounds(155, 300, 50, 20);
		JTextField GG = new JTextField();
		GG.setBounds(220, 300, 50, 20);
		JTextField GH = new JTextField();
		GH.setBounds(280, 300, 50, 20);
		
		JButton C = new JButton("Calcular");
		C.setBounds(210, 210, 100, 50);
		add(IIP);
		add(GA);
		add(GB);
		add(GC);
		add(GD);
		add(GE);
		add(GF);
		add(GG);
		add(GH);
		add(C);
		C.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String A = GA.getText();
				String B = GB.getText();
				String C = GC.getText();
				String D = GD.getText();
				String E = GE.getText();
				String F = GF.getText();
				String G = GG.getText();
				String H = GH.getText();
				int IA = 0;
				int IB = 0;
				int IC = 0;
				int ID = 0;
				int IE = 0;
				int IF = 0;
				int IG = 0;
				int IH = 0;
				String IP = A+":"+B+":"+C+":"+D+":"+E+":"+F+":"+G+":"+H;
				
				//EVALUACIÓN TIPOS DE ESCRITURA PARA LA DIRECCIÓN IPv6
				if (A.equals("")) {
					A = "::";
					IA=0;
				}else {
					IA = Integer.parseInt(A, 16);
				}
				if (B.equals("")) {
					B = "::";
					IB=0;
				
				}else {
					IB = Integer.parseInt(B, 16);
				}
				if (C.equals("")) {
					C = "::";
					IC=0;
				}else {
					IC = Integer.parseInt(C, 16);
				}
				if (D.equals("")) {
					D = "::";
					ID=0;
				}else {
					ID= Integer.parseInt(D, 16);
				}
				if (E.equals("")) {
					E = "::";
					IE=0;
				}else {
					IE = Integer.parseInt(E, 16);
				}
				if (F.equals("")) {
					F = "::";
					IF=0;
				}else {
					IF = Integer.parseInt(F, 16);
				}
				if (G.equals("")) {
					G = "::";
					IG=0;
				}else {
					IG = Integer.parseInt(G, 16);
				}
				if (H.equals("")) {
					H = "::";
					IH=0;
				}else {
					IH = Integer.parseInt(H, 16);
				}
				
				
				
				o.setText(IP);
				
				//TIPOS DE DIRECCIONES IPv6
				
			if (IA==0) {
				//DIRECCIÓN NO ESPECIFICADA:
				if (IB==0&&IC==0&&ID==0&&IE==0&&IF==0&&IG==0&&IH==0) {
					String NEIP = "0:0:0:0:0:0:0:0";
					String NIP = "DIRECCIÓN IP NO ESPECIFICADA:\n"+ NEIP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
				//DIRECCIÓN DE LOOPBACK
				else if (IB==0&&IC==0&&ID==0&&IE==0&&IF==0&&IG==0&&IH==1) {
					String NIP = "DIRECCIÓN IP DE LOOPBACK:\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					
				}
				else if (IB==0&&IC==0&&D.equals("FFFF")&&(IE>=0||IE<=255)&&(IF>=0||IF<=255)&&(IG>=0||IG<=255)&&(IH>=0||IH<=255)) {
					String NIP = "DIRECCIÓN IP DE SOFTWARE\n(IPv4 Mapeada):\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (IB==0&&C.equals("FFFF")&&ID==0&&(IE>=0||IE<=255)&&(IF>=0||IF<=255)&&(IG>=0||IG<=255)&&(IH>=0||IH<=255)) {
					String NIP = "DIRECCIÓN IP DE SOFTWARE\n(IPv4 Traducida):\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					} 
				
				
			}else if (IA>=64&&IA<=2001) {
					 if (B.equals("FF9B")&&IC==0 && ID==0 && (IE>=0||IE<=255)&&(IF>=0||IF<=255)&&(IG>=0||IG<=255)&&(IH>=0||IH<=255) ) {
							String NIP = "DIRECCIÓN IP DE INTERNET\n(T. IPv4/IPv6):\n"+ IP;
							o.setText(NIP);
							Object [] O = {BD.IDMAX() ,"0", NIP, ""};
							BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (IB==0 && IC == 0 && ID==0 &&  (IE>=0||IE<=65535)&&(IF>=0||IF<=65535)&&(IG>=0||IG<=65535)&&(IH>=0||IH<=65535) ) {
					String NIP = "DIRECCIÓN IP DE ENRUTAMIENTO\n(Prefijo):\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (IB==0 &&(IC>=0||IC<=65535)&&(ID>=0||ID<=65535)&&  (IE>=0||IE<=65535)&&(IF>=0||IF<=65535)&&(IG>=0||IG<=65535)&&(IH>=0||IH<=65535)) {
					String NIP = "DIRECCIÓN IP DE INTERNET\n(Túnel Teredo):\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (IB>=20||IB<=3512) {
					if (IB==20&&(IC>=0||IC<=65535)&&(ID>=0||ID<=65535)&&  (IE>=0||IE<=65535)&&(IF>=0||IF<=65535)&&(IG>=0||IG<=65535)&&(IH>=0||IH<=65535)) {
					String NIP = "DIRECCIÓN IP DE SOFTWARE\n(ORCHIDv2):\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else  {
					String NIP = "DIRECCIÓN IP DE DOCUMENTACIÓN\n"+ IP;
					o.setText(NIP);
					Object [] O = {BD.IDMAX() ,"0", NIP, ""};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
					 
			}
		}else if (IA>=2002&&IA<=2003)  {
			if ((IB>=0&&IB<=65535)&&(IC>=0||IC<=65535)&&(ID>=0||ID<=65535)&&  (IE>=0||IE<=65535)&&(IF>=0||IF<=65535)&&(IG>=0||IG<=65535)&&(IH>=0||IH<=65535)) {
			String NIP = "DIRECCIÓN IP DE INTERNET\n(No en uso actualmente)\n"+ IP;
			o.setText(NIP);
			Object [] O = {BD.IDMAX() ,"0", NIP, ""};
			BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
	}
		}else if (IA>=64512&&IA<=65023) {
			String NIP = "DIRECCIÓN IP DE RED PRIVADA\n(DIRECCIÓN LOCAL ÚNICA)\n"+ IP;
			o.setText(NIP);
			Object [] O = {BD.IDMAX() ,"0", NIP, ""};
			BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
		}else if (IA>=65152&&IA<=65215) {
			String NIP = "DIRECCIÓN IP DE ENLACE\n(DIRECCIÓN ENLACE LOCAL)\n"+ IP;
			o.setText(NIP);
			Object [] O = {BD.IDMAX() ,"0", NIP, ""};
			BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
	   }else {
			String NIP = "DIRECCIÓN IP DE INTERNET\n(DIRECCIÓN MULTIDIFUNSIÓN)\n"+ IP;
			o.setText(NIP);
			Object [] O = {BD.IDMAX() ,"0", NIP, ""};
			BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
		}
			}
			
		});
		
		
		
		
		
		
		
		
	}
	
	
	

	
	
	
	
	
	
	
	
	
}

//CALCULADOR DE IP DADO UN NÚMERO DE HOSTS
class HIP extends JPanel{
BDCalculadora BD = BDCalculadora.getInstances();
public HIP(){
	setLayout(null);
	setSize(400, 400);
	setBackground(Color.DARK_GRAY);
	JTextArea o = new JTextArea();
	o.setBounds(70, 15, 250, 180);
	add(o);
	JLabel Hosts = new JLabel(" Número de Hosts: ");
	Hosts.setBounds(130, 230, 150, 100);
	JTextField H = new JTextField();
	H.setBounds(240, 270, 50, 20);
	JButton C = new JButton("Calcular");
	C.setBounds(210, 210, 100, 50);
	add(Hosts);
	add(H);
	add(C);

	C.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//SEA LA FÓRMULA DE HOST = (2POW(32-n))-2 dónde n representa la máscara.
			String M="";
			int Host = Integer.parseInt(H.getText());
			double a = Math.log(Host);
			double N =32-(a/Math.log(2));
			int n = (int)(N);
			//PARA LA MASCARA 00000000.00000000.00000000.00000000 ->Se asignarán n 1´s.
			int MA=00000000;
			int MB=00000000;
			int MC=00000000;
			int MD=00000000;
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (n>0&&n<=8) {
				if (n==0) {
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==1) {
					MA=10000000;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==2) {
					MA=11000000;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==3) {
					MA=11100000;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if(n==5) {
					MA=11110000;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==5) {
					MA=11111000;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==6) {
					MA=11111100;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==7) {
					MA=11111110;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else {
					MA=11111111;
					M="Máscara perteneciente a una IP de clase A.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP = "IP Óptima: 10.0.0.0/"+n;	
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
				
			
			}else if (n>8&&n<=16) {
				if (n==9) {
					MA=11111111;
					MB=10000000;
					M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 172.16.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==10) {
						MA=11111111;
						MB=11000000;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==11) {
						MA=11111111;
						MB=11100000;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==12) {
						MA=11111111;
						MB=11110000;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==13) {
						MA=11111111;
						MB=11111000;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==14) {
						MA=11111111;
						MB=11111100;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else if (n==15) {
						MA=11111111;
						MB=11111110;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}else {
						MA=11111111;
						MB=11111111;
						M="Máscara perteneciente a una IP de clase B.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
						String IP ="IP ótima: 172.16.0.0/"+n;
						o.setText(IP+"\n"+M);
						Object [] O = {BD.IDMAX() ,IP, "0", M};
						BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					}
			}else { 
				if (n==17) {
					MA=11111111;
					MB=11111111;
					MC=10000000;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==18) {
					MA=11111111;
					MB=11111111;
					MC=11000000;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					o.setText(IP+"\n"+M);
				}else if(n==19) {
					MA=11111111;
					MB=11111111;
					MC=11100000;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==20) {
					MA=11111111;
					MB=11111111;
					MC=11110000;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else if (n==21) {
					MA=11111111;
					MB=11111111;
					MC=11111000;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					o.setText(IP+"\n"+M);
				}else if (n==22) {
					MA=11111111;
					MB=11111111;
					MC=11111100;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
					o.setText(IP+"\n"+M);
				}else if (n==23) {
					MA=11111111;
					MB=11111111;
					MC=11111110;
					M="Máscara perteneciente a una IP de clase C.\nMáscara: "+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}else {
					MA=11111111;
					MB=11111111;
					MC=11111111;
					M="Máscara perteneciente a una IP de clase C.\nMáscara:\n"+String.valueOf(MA)+"."+String.valueOf(MB)+"."+String.valueOf(MC)+"."+String.valueOf(MD);
					String IP ="IP ótima: 192.168.0.0/"+n;
					o.setText(IP+"\n"+M);
					Object [] O = {BD.IDMAX() ,IP, "0", M};
					BD.dbPrepareStatement("INSERT INTO BDIP(ID ,IPv4, IPv6, Clase)", O);
				}
		
			}
			
				
			
			
			
			
		}
		
	});
	
	
	
}
	


	
	
	
}
	
class A extends JPanel{
	
	public A() {
		setLayout(null);
		setBackground(Color.darkGray);
		JTextArea o = new JTextArea();
		o.setBounds(200, 30, 300, 300);
		o.setText("INSTRUCCIONES DE USO\n IPv4: Escribir la dirección IPv4\nrespetando los espacios.\nPosterior escribir una máscara de red.\nIPv6: Escribir la IPv6 respetando los espacios.\n Cal. Host IPv4: Escribir el n° de hosts.");
		add(o);
	}
	
}
	
	



