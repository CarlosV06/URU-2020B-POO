package bd;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.*;
import bd.BD_Zoológico;
import gráficos.Caninos;
import gráficos.Felinos;
import gráficos.Primates;
import gráficos.*;
public class APPZoológico extends JFrame {
private JPanel Menú = new JPanel();
	//CONSTRUCTOR LA VENTANA
	public	APPZoológico() {
		setSize(800,800);
		setTitle("APP de su Zoológico");
		setLayout(new GridLayout(6, 0, 5, 2));
		this.Menú = new JPanel();
		add(Menú);
		JButton Volver = new JButton("Volver Menú");
		JButton VerA = new JButton("Ver Animales");
		VerA.setBounds(200, 100, 100, 200);
		Menú.add(VerA);
		JButton AgregarA = new JButton("Agregar Animales");
		AgregarA.setBounds(190, 100, 100, 200);
		Menú.add(AgregarA);
		JButton EliminarA = new JButton("EliminarA");
		EliminarA.setBounds(5, 100, 100, 200);
		Menú.add(EliminarA);
		JButton ModificarA = new JButton("ModificarA");
		ModificarA.setBounds(100, 100, 200, 100);
		Menú.add(ModificarA);
		AgregarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarA o = new AgregarA();
				setContentPane(o);
				add(Volver);
			}
		});
		
		
		
		
		
		
		
		VerA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerAnimales o = new VerAnimales();
				setContentPane(o);
				add(Volver);
		}
		
	});
	
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(Menú);
			}
		});
		
		
		EliminarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				EliminarA o = new EliminarA();
				setContentPane(o);
				add(Volver);
				
			}
		});
		
	ModificarA.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			PlantillaModifica o = new PlantillaModifica();
			setContentPane(o);
			add(Volver);
		}
	});
		
		
		
		
		
		
		
	}
	
	
	class VerAnimales extends JPanel{
		BD_Zoológico BD = BD_Zoológico.getInstances();
		public VerAnimales(){
			setSize(800,800);
			setLayout(null);
			JButton Volver = new JButton("Volver Menú");
			Volver.setBounds(200, 100, 300, 30);
			add(Volver);
			JTextArea mostrar = new JTextArea();
			mostrar.setText(BD.dbStatement("SELECT*FROM SistemaZoológico"));
			mostrar.setBounds(20, 200, 800, 200);
			add(mostrar);
			Volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setContentPane(Menú);
					invalidate();
					validate();			
					
				}
			});
		}
	}
	
//MENÚ PARA AÑADIR ALGÚN ANIMAL POR SELECCIÓN MULTIPLE (ESCOGER EL TIPO Y LA CLASE A AÑADIR).
class AgregarA extends JPanel  {
			private JPanel SelTA;
				public AgregarA(){
					setSize(800,800);
					this.SelTA = new JPanel();
					add(SelTA);
					JButton C = new JButton("1- Caninos");
					JButton F = new JButton("2- Felinos");
					JButton P = new JButton("3- Primates");
					JButton Volver = new JButton("Volver Menú");
					JButton VolverSel = new JButton("Volver Sel");
					SelTA.add(VolverSel);
					SelTA.add(Volver);
					SelTA.add(C);
					SelTA.add(F);
					SelTA.add(P);
					//Instancia para las nuevas vistas dependiendo de la selección
					C.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								Caninos Cani = new Caninos();
								setContentPane(Cani);
								invalidate();
								validate();
								Cani.add(VolverSel);
								VolverSel.setVisible(true);
							}
				});
					
				F.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Felinos Feli = new Felinos();
						setContentPane(Feli);
						invalidate();
						validate();
						Feli.add(VolverSel);
						VolverSel.setVisible(true);
					}
				});
					
				
				P.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Primates Pri = new Primates();
							setContentPane(Pri);
							invalidate();
							validate();
							Pri.add(VolverSel);
							VolverSel.setVisible(true);
						}
				});
					
					VolverSel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setContentPane(SelTA);
							invalidate();
							validate();
						}
					});
					
					Volver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setContentPane(Menú);
							invalidate();
							validate();
					
			
				}
			});			
		}
		
		
		
		
		
	}
	
//MENÚ PARA ELIMINAR UN ANIMAL EXISTENTE EN LA BASE DE DATOS.
class EliminarA extends JPanel {
	BD_Zoológico BD = BD_Zoológico.getInstances();
	private int IDa;
	private JTextField IDA;
	public EliminarA() {
		setSize(800,800);
		setLayout(null);
		JButton Volver = new JButton("Volver Menú");
		Volver.setBounds(200, 350, 100, 100);
		add(Volver);
		JLabel ID = new JLabel("ID:");
		ID.setBounds(200, 50, 200, 100);
		add(ID);
		this.IDA = new JTextField();
		IDA.setBounds(210, 60, 50, 50);
		add(IDA);
		JButton El = new JButton("Eliminar");
		El.setBounds(260, 50, 100, 100);
		add(El);
		El.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IDa = Integer.parseInt(IDA.getText());
				BD.EliminarA("DELETE FROM TABLE WHERE IDAnimal = IDa", IDa);
			}
		});
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(Menú);
				invalidate();
				validate();
		
			}
		
	});
	
	
	
}
}

//MENÚ PARA MODIFICAR ALGÚN ANIMAL EXISTENTE EN LA BASE DE DATOS.
class PlantillaModifica extends JPanel{
	BD_Zoológico BD = BD_Zoológico.getInstances();
private JTextField IDA, PesoA, AlturaA, ColorA;
	public PlantillaModifica() {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
		JButton Volver = new JButton("Volver Menú");
		Volver.setBounds(200, 350, 100, 100);
		add(Volver);
		//Pedir ID para Animal
		JLabel ID = new JLabel("ID:");
		add(ID);
		this.IDA = new JTextField();
		add(IDA);
		//Pedir peso animal
		JLabel IPeso = new JLabel("Peso (Kg): ");
		add(IPeso);
		this.PesoA = new JTextField();
		add(PesoA);
		//Pedir Tamaño animal
		JLabel ITamaño = new JLabel("Tamaño (Cm): ");
		add(ITamaño);
		this.AlturaA = new JTextField();
		add(AlturaA);
		//Pedir color animal
		JLabel IColor = new JLabel("Color: ");
		add(IColor);
		this.ColorA = new JTextField();
		add(ColorA);
		JButton Modificar = new JButton("Modificar");
		add(Modificar);
		Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
		String	Pes = PesoA.getText();
		String	Alt = AlturaA.getText();
		String	IDa = IDA.getText();
		String	Color = ColorA.getText();
				
			String[] obj = {Pes, Alt, Color, IDa}; 
				BD.ModificarA(obj);
				add(Volver);
				Volver.setVisible(true);
					}
				});
		
		
		
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(Menú);
				invalidate();
				validate();
		
			}
		
	});
		
		
		
		
		
	
	}
}













}
