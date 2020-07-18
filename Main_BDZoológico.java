package bd;
import bd.BD_Zoológico;
import java.io.DataOutputStream;
import java.net.Socket;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JFrame;

import bd.APPZoológico;
public class Main_BDZoológico {
	public static void main(String Args[]) { 
	
	BD_Zoológico BD =  BD_Zoológico.getInstances();
	APPZoológico IU = new APPZoológico();
	IU.setVisible(false);
	IU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
