package gr�ficos;
import java.awt.FlowLayout;
import gr�ficos.UI1;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import gr�ficos.UI1;
import primates.*;

public class Primates extends JPanel {
	private JTextField Peso, Altura, Color;
	public Primates(ArrayList Animales) {
		setSize(800,800);
		JPanel Animal = new JPanel();
		add(Animal);
		JLabel Sel =new JLabel ("Seleccione un animal: ");
		JButton Gorila = new JButton("1- Gorila");
		JButton L�murCA = new JButton("2- L�mur cola Anillada");
		Animal.add(Sel);
		Animal.add(Gorila);
		Animal.add(L�murCA);
		Gorila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PlantillaGorilas o = new PlantillaGorilas(Animales);
			add(o);
			o.setVisible(true);
			Animal.setVisible(false);
			}
		});
		L�murCA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantillaL�mur o = new PlantillaL�mur(Animales);
				add(o);
				o.setVisible(true);
				Animal.setVisible(false);
			}
		});
}

}

//PLANTILLA PARA AGREGAR GORILLAS
class PlantillaGorilas extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaGorilas(ArrayList Animales) {
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
				Gorilla Go = new Gorilla(Pes, Alt, ColorA.getText());
				Go.setCAnimal("Gorila");
				Go.setTipoAnimal("Primate");
				Animales.add(Go);
				setVisible(false);
			setVisible(false);
				
			}
		});
	}
}

//PLANTILLA PARA AGREGAR L�MURES

class PlantillaL�mur extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaL�mur(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
		//Pedir peso animal
		JLabel IPeso = new JLabel("Peso (Kg): ");
		add(IPeso);
		this.PesoA = new JTextField();
		add(PesoA);
		//Pedir Tama�o animal
		JLabel ITama�o = new JLabel("Tama�o(Cm) : ");
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
				L�mur_Cola_Anillada L� = new L�mur_Cola_Anillada(Pes, Alt, ColorA.getText());
				L�.setCAnimal("Gorila");
				L�.setTipoAnimal("Primate");
				Animales.add(L�);
				setVisible(false);
			setVisible(false);
				
			}
		});
	}
}
