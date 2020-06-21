package main;
import animal.Animal;

import caninos.*;
import felinos.*;
import primates.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Zoo_Main {
	public static void main (String Args[]) {
		int op1, op2, o=0, p=0,a=0;
		float Peso, Altura;
		String Color;
		System.out.println("Bienvenido al registro de su Zoo");
		ArrayList <Animal> animales = new ArrayList<Animal>();
		
do {
		
		System.out.println("Usted puede: 1-. A�adir animales\n 2-. Consultar animales\n 3-. Salir ");
		
		Scanner Lectura = new Scanner(System.in);
		op1 = Lectura.nextInt();
	
		switch (op1) {
		case 1: {
			System.out.println("Tipo de animal: 1-. Canino 2-. Felino 3-. Primate ");
			op2 = Lectura.nextInt();
			switch (op2) {
			case 1: {
				System.out.println("Seleccione un Animal: 1-. Coyote 2-. Zorro Culpeo");
				a = Lectura.nextInt();
				if (a==1) {
					System.out.println("Se va a agregar un Coyote, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						Coyote NuevoCoyote = new Coyote(60,45, "Gris");
						NuevoCoyote.setCAnimal("Coyote");
						NuevoCoyote.setTipoAnimal("Canino");
						animales.add(NuevoCoyote);
						System.out.println("Se ha a�adido un nuevo animal Coyote del tipo canino: ");
						System.out.println("Cuyo par�metros predefinidos son: Peso: 60Kg\n Altura: 45 cm\n Color: Gris");
					}  else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						Coyote NuevoCoyote = new Coyote(Peso, Altura, Color);
						NuevoCoyote.setCAnimal("Coyote");
						NuevoCoyote.setTipoAnimal("Canino");
						animales.add(NuevoCoyote);
						System.out.println("Se ha a�adido un nuevo animal Coyote del tipo canino: ");
						System.out.println("Cuyo par�metros son:\n Peso: "+Peso);
						System.out.println("Altura: \n"+Altura);
						System.out.println("Color: \n"+Color);
					}
					//FIN IF p
					
				} //FIN IF a
				else {
					System.out.println("Se va a agregar un Zorro Culpeo, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						Zorro_Culpeo NuevoZorro = new Zorro_Culpeo(50,35, "Naranja");
						NuevoZorro.setTipoAnimal("Canino");
						NuevoZorro.setCAnimal("Zorro Culpeo");
						animales.add(NuevoZorro);
						System.out.println("Se ha a�adido un nuevo animal Zorro Culpeo del tipo canino: "+NuevoZorro);
						System.out.println("Cuyo par�metros predefinidos son:\n Peso: 50Kg\n Altura: 35 cm\n Color: Naranja");
					}  else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						Zorro_Culpeo NuevoZorro = new Zorro_Culpeo(Peso, Altura, Color);
						NuevoZorro.setTipoAnimal("Canino");
						NuevoZorro.setCAnimal("Zorro Culpeo");
						animales.add(NuevoZorro);
						System.out.println("Se ha a�adido un nuevo animal Zorro Culpeo del tipo canino: ");
						System.out.println("Cuyo par�metros son:\n Peso: Kg"+Peso);
						System.out.println("Altura: Cm\n"+Altura);
						System.out.println("Color: \n"+Color);
				}
		
				
			}// FIN CONDICIONALES
				break;
			}// FIN CASE 1
			case 2: {
				System.out.println("Seleccione un Animal: 1-. Le�n 2-. Tigre");
				a = Lectura.nextInt();
				if (a==1) {
					System.out.println("Se va a agregar un Le�n, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						Le�n NuevoLe�n = new Le�n(90,125, "Amarillo");
						NuevoLe�n.setTipoAnimal("Felino");
						NuevoLe�n.setCAnimal("Le�n");
						animales.add(NuevoLe�n);
						System.out.println("Se ha a�adido un nuevo animal Le�n del tipo felino: ");
						System.out.println("Cuyo par�metros predefinidos son: Peso: 80Kg\n Altura: 125 cm\n Color: Amarillo");
					}  else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						Le�n NuevoLe�n = new Le�n(Peso, Altura, Color);
						NuevoLe�n.setTipoAnimal("Felino");
						NuevoLe�n.setCAnimal("Le�n");
						animales.add(NuevoLe�n);
						System.out.println("Se ha a�adido un nuevo animal Le�n del tipo felino: ");
						System.out.println("Cuyo par�metros son:\n Peso: Kg"+Peso);
						System.out.println("Altura: Cm\n"+Altura);
						System.out.println("Color: \n"+Color);		
			}
				}//FIN IF a
				else {
					System.out.println("Se va a agregar un Tigre, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						Tigre NuevoTigre = new Tigre(70, 115, "Amarillo con rayas negras");
						NuevoTigre.setTipoAnimal("Felino");
						NuevoTigre.setCAnimal("Tigre");
						animales.add(NuevoTigre);
						System.out.println("Se ha a�adido un nuevo animal Tigre del tipo felino: ");
						System.out.println("Cuyo par�metros predefinidos son: Peso: 70Kg\n Altura: 115 cm\n Color: Amarillo con rayas negras");
					}  else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						Tigre NuevoTigre = new Tigre(Peso, Altura, Color);
						NuevoTigre.setTipoAnimal("Felino");
						NuevoTigre.setCAnimal("Tigre");
						animales.add(NuevoTigre);
						System.out.println("Se ha a�adido un nuevo animal Tigre del tipo felino: ");
						System.out.println("Cuyo par�metros son:\n Peso: Kg"+Peso);
						System.out.println("Altura: Cm\n"+Altura);
						System.out.println("Color: \n"+Color);	
				}//FIN ELSE
				}//FIN ELSE
				break;
			}//FIN CASE 2 OP2
			
			case 3: {
				System.out.println("Seleccione un Animal: 1-. Gorila 2-. L�mur de cola Anillada");
				a = Lectura.nextInt();
				if (a==1) {
					System.out.println("Se va a agregar un Gorila, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						Gorilla NGor = new Gorilla(150, 205, "Negro espalda plateada");
						NGor.setTipoAnimal("Primate");
						NGor.setCAnimal("Gorila");
						animales.add(NGor);
						System.out.println("Se ha a�adido un nuevo animal Gorila del tipo primate: ");
						System.out.println("Cuyo par�metros predefinidos son: Peso: 150Kg\n Altura: 205 cm\n Color: Negro espalda plateada");
					}// FIN IF P
					else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						Gorilla NGor = new Gorilla(Peso, Altura, Color);
						NGor.setTipoAnimal("Primate");
						NGor.setCAnimal("Gorila");
						animales.add(NGor);
						System.out.println("Se ha a�adido un nuevo animal Gorila del tipo primates: "+NGor);
						System.out.println("Cuyo par�metros son:\n Peso: Kg"+Peso);
						System.out.println("Altura: Cm\n"+Altura);
						System.out.println("Color: \n"+Color);
			}
				} //FIN IF A
				else {
					System.out.println("Se va a agregar un L�mur de cola Anillada, �desea modificar los par�metros predefinidos?\n 1 = No 2 = Si");
					p = Lectura.nextInt();
					if (p==1) {
						L�mur_Cola_Anillada NL�mur = new L�mur_Cola_Anillada(45, 50, "Gris con rayas negras");
						NL�mur.setTipoAnimal("Primate");
						NL�mur.setCAnimal("L�mur de cola Anillada");
						animales.add(NL�mur);
						System.out.println("Se ha a�adido un nuevo animal L�mur Cola Anillada del tipo primate: ");
						System.out.println("Cuyo par�metros predefinidos son: Peso: 45Kg\n Altura: 50 cm\n Color: Gris con rayas negras");
					}//FIN IF P
					else {
						System.out.println("Inserte el Peso del animal:");
						Peso = Lectura.nextFloat();
						System.out.println("Inserte la Altura del animal:");
						Altura = Lectura.nextFloat();
						System.out.println("Inserte el color del animal: ");
						Color = Lectura.next();
						L�mur_Cola_Anillada NL�mur = new L�mur_Cola_Anillada(Peso, Altura, Color);
						NL�mur.setTipoAnimal("Primate");
						NL�mur.setCAnimal("L�mur de cola Anillada");
						animales.add(NL�mur);
						System.out.println("Se ha a�adido un nuevo animal L�mur Cola Anillada del tipo primate: ");
						System.out.println("Cuyo par�metros son:\n Peso: Kg"+Peso);
						System.out.println("Altura: Cm\n"+Altura);
						System.out.println("Color: \n"+Color);
				}
				}//FIN CONDICIONALES CASE 3 OP2
				break;
			} //FIN CASE 3 OP2 	
			}//FIN SWITCH OP2
			break;
		}//FIN CASE 1 OP1
	
		case 2: {
			System.out.println("Actualmente usted tiene los siguentes animales: "+animales.toString());
			break;
		}
	} //FIN SWITCH OP1
	
	
	
	
}while(o!=3 || o==3);  //FIN DO-WHILE
		
		System.out.println("Hasta la pr�xima...");
		
} //FIN M�TODO MAIN
	
}	


