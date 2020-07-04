package gráficos;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.*;

import animal.Animal;



public class UI1 extends JFrame {
	public JPanel Menú = new JPanel();
	public ArrayList<Animal> Animales = new ArrayList<Animal>();
	
	//VENTANA CON SUS PROPIEDADES 
	public UI1() {
		setTitle("Gestor de su Zoológico");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 0, 5, 2));
		this.Menú = new JPanel();
		add(Menú);
		JButton A = new JButton("1- Agregar Animales");
		JButton B = new JButton("2- Consultar Animales");
		JButton Volver = new JButton("Volver");
		Menú.add(Volver);
		Menú.add(A);
		Menú.add(B);
		A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarA Agregar = new AgregarA(Animales);
					setContentPane(Agregar);
					invalidate();
					validate();
					
			}
		});
		B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerA Ver = new VerA(Animales);
					setContentPane(Ver);
					invalidate();
					validate();
					Ver.add(Volver);
					Volver.setVisible(true);
				
			}
		});
		
	
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setContentPane(Menú);
				}
	});
	
			
		
	}

//PANEL Agregar Animales (Vista 2 del programa para el usuario)
class AgregarA extends JPanel  {
	private JPanel SelTA;
	//Método get para poder regresar a este panel desde el agregado de animales
	public JPanel getPanel() {
		return SelTA;
	}
	
		public AgregarA(ArrayList Animales){
			setSize(800,800);
			this.SelTA = new JPanel();
			add(SelTA);
			JButton C = new JButton("1- Caninos");
			JButton F = new JButton("2- Felinos");
			JButton P = new JButton("3- Primates");
			JButton Volver = new JButton("Volver Menú");
			JButton VolverSel = new JButton("Volver Sel");
			SelTA.add(Volver);
			SelTA.add(VolverSel);
			SelTA.add(C);
			SelTA.add(F);
			SelTA.add(P);
			//Instancia para las nuevas vistas dependiendo de la selección
			C.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Caninos Cani = new Caninos(Animales);
						setContentPane(Cani);
						invalidate();
						validate();
						Cani.add(VolverSel);
						VolverSel.setVisible(true);
					}
		});
			
		F.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Felinos Feli = new Felinos(Animales);
				setContentPane(Feli);
				invalidate();
				validate();
				Feli.add(VolverSel);
				VolverSel.setVisible(true);
			}
		});
			
		
		P.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Primates Pri = new Primates(Animales);
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

//PANEL Ver Animales (tercera vista desde el panel principal)
public class VerA extends JPanel {
	
	
	public VerA (ArrayList Animales){
		setSize(800,800);
		setLayout(null);
		JTextArea Mostrar = new JTextArea("Animales en sistema:" +"\n"+Animales);
		Mostrar.setBounds(20, 200, 800, 200);
		add(Mostrar);
		
		
		
		
}
	
} 




}//FIN CUERPO DE CLASE UI