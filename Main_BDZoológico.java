package bd;
import bd.BD_Zool�gico;
import java.io.DataOutputStream;
import java.net.Socket;

import java.awt.Component;
import java.awt.Window;

import javax.swing.JFrame;

import bd.APPZool�gico;
public class Main_BDZool�gico {
	public static void main(String Args[]) { 
	
	BD_Zool�gico BD =  BD_Zool�gico.getInstances();
	APPZool�gico IU = new APPZool�gico();
	IU.setVisible(false);
	IU.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}
