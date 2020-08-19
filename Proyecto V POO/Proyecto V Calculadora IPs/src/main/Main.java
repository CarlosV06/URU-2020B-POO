package main;
import javax.swing.JFrame;
import base_de_datos.BDCalculadora;

import interfaz.InterfazU;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BDCalculadora BD = BDCalculadora.getInstances();
		InterfazU u = new InterfazU();
		u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
