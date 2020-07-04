package gráficos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import caninos.*;
import javax.swing.*;
public class Caninos extends JPanel {
	public Caninos (ArrayList Animales){
		setSize(800,800);
		JPanel Animal = new JPanel();
		add(Animal);
		JLabel Sel = new JLabel("Seleccione un animal: ");
		JButton Coyote = new JButton("1- Coyote");
		JButton ZorroC = new JButton("2- Zorro Culpeo");
		Animal.add(Sel);
		Animal.add(Coyote);
		Animal.add(ZorroC);
		Coyote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantillaCoyote o = new PlantillaCoyote(Animales);
				add(o);
				o.setVisible(true);
				Animal.setVisible(false);
			}
		});
		
		ZorroC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantillaZorroC z = new PlantillaZorroC(Animales);
				add(z);
				z.setVisible(true);
				Animal.setVisible(false);
			}
		});
		
		
	}

}



//PLANTILLA PARA AGREGAR A LOS COYOTES
class PlantillaCoyote extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes,Alt;
	public PlantillaCoyote(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
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
		JButton Agregar = new JButton("Agregar");
		add(Agregar);
		Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pes = Float.parseFloat(PesoA.getText());
				Alt = Float.parseFloat(AlturaA.getText());
				Coyote co = new Coyote(Pes, Alt, ColorA.getText());
				co.setCAnimal("Coyote");
				co.setTipoAnimal("Canino");
				Animales.add(co);
				setVisible(false);
					}
				});
		
		
	
	}
}

//PLANTILLA PARA AGREGAR A LOS ZORROZ CULPEOS
class PlantillaZorroC extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes,Alt;
	public PlantillaZorroC(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
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
		JButton Agregar = new JButton("Agregar");
		add(Agregar);
		Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pes = Float.parseFloat(PesoA.getText());
				Alt = Float.parseFloat(AlturaA.getText());
				Zorro_Culpeo Zc = new Zorro_Culpeo(Pes, Alt, ColorA.getText());
				Zc.setCAnimal("Zorro Culpeo");
				Zc.setTipoAnimal("Canino");
				Animales.add(Zc);
				setVisible(false);
					}
				});
		
		
	
	}
}

