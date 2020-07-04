package gráficos;
import java.awt.FlowLayout;
import gráficos.UI1;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import gráficos.UI1;
import primates.*;

public class Primates extends JPanel {
	private JTextField Peso, Altura, Color;
	public Primates(ArrayList Animales) {
		setSize(800,800);
		JPanel Animal = new JPanel();
		add(Animal);
		JLabel Sel =new JLabel ("Seleccione un animal: ");
		JButton Gorila = new JButton("1- Gorila");
		JButton LémurCA = new JButton("2- Lémur cola Anillada");
		Animal.add(Sel);
		Animal.add(Gorila);
		Animal.add(LémurCA);
		Gorila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PlantillaGorilas o = new PlantillaGorilas(Animales);
			add(o);
			o.setVisible(true);
			Animal.setVisible(false);
			}
		});
		LémurCA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlantillaLémur o = new PlantillaLémur(Animales);
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

//PLANTILLA PARA AGREGAR LÉMURES

class PlantillaLémur extends JPanel{
private JTextField PesoA, AlturaA, ColorA;
private float Pes, Alt;
	public PlantillaLémur(ArrayList Animales) {
		setSize(800, 800);
		setLayout(new GridLayout(2,0,6,2));
		//Pedir peso animal
		JLabel IPeso = new JLabel("Peso (Kg): ");
		add(IPeso);
		this.PesoA = new JTextField();
		add(PesoA);
		//Pedir Tamaño animal
		JLabel ITamaño = new JLabel("Tamaño(Cm) : ");
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
				Lémur_Cola_Anillada Lé = new Lémur_Cola_Anillada(Pes, Alt, ColorA.getText());
				Lé.setCAnimal("Gorila");
				Lé.setTipoAnimal("Primate");
				Animales.add(Lé);
				setVisible(false);
			setVisible(false);
				
			}
		});
	}
}
