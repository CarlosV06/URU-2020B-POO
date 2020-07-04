package gr�ficos;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import caninos.Coyote;
import primates.*;
import felinos.*;



public class Felinos extends JPanel {
	
		public Felinos(ArrayList Animales) {
			setSize(800,800);
			JPanel Animal = new JPanel();
			add(Animal);
			JLabel Sel =new JLabel ("Seleccione un animal: ");
			JButton Le�n = new JButton("1- Le�n");
			JButton Tigre = new JButton("2- Tigre");
			Animal.add(Sel);
			Animal.add(Le�n);
			Animal.add(Tigre);
			Le�n.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PlantillaLe�n o = new PlantillaLe�n(Animales);
					add(o);
					o.setVisible(true);
					Animal.setVisible(false);
		}

});
			Tigre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				PlantillaTigre o = new PlantillaTigre(Animales);
				add(o);
				o.setVisible(true);
				Animal.setVisible(false);
				}
			});
		}
}

//PLANTILLA PARA AGREGAR LEONES
class PlantillaLe�n extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaLe�n(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
		//Pedir peso animal
		JLabel IPeso = new JLabel("Peso (Kg): ");
		add(IPeso);
		this.PesoA = new JTextField();
		add(PesoA);
		//Pedir Tama�o animal
		JLabel ITama�o = new JLabel("Tama�o (Cm): ");
		add(ITama�o);
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
				Le�n Lo = new Le�n(Pes, Alt, ColorA.getText());
				Lo.setCAnimal("Le�n");
				Lo.setTipoAnimal("Felino");
				Animales.add(Lo);
				setVisible(false);
			setVisible(false);
				
			}
		});
	}
}

//PLANTILLA PARA AGREGAR TIGRES
class PlantillaTigre extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaTigre(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
		//Pedir peso animal
		JLabel IPeso = new JLabel("Peso (Kg): ");
		add(IPeso);
		this.PesoA = new JTextField();
		add(PesoA);
		//Pedir Tama�o animal
		JLabel ITama�o = new JLabel("Tama�o (Cm): ");
		add(ITama�o);
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
				Tigre Ti = new Tigre(Pes, Alt, ColorA.getText());
				Ti.setCAnimal("Tigre");
				Ti.setTipoAnimal("Felino");
				Animales.add(Ti);
				setVisible(false);
			setVisible(false);
				
			}
		});
	}
}