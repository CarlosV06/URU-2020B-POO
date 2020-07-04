package gráficos;
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
			JButton León = new JButton("1- León");
			JButton Tigre = new JButton("2- Tigre");
			Animal.add(Sel);
			Animal.add(León);
			Animal.add(Tigre);
			León.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PlantillaLeón o = new PlantillaLeón(Animales);
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
class PlantillaLeón extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaLeón(ArrayList Animales) {
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
				León Lo = new León(Pes, Alt, ColorA.getText());
				Lo.setCAnimal("León");
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