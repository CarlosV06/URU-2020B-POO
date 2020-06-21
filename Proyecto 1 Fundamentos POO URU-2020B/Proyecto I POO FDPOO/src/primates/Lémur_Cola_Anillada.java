package primates;
import animal.Animal;
import interf_comunicar.Comunicar;


public class L�mur_Cola_Anillada extends Animal implements Comunicar{

	public L�mur_Cola_Anillada(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
	
	}
	@Override
	public void Comunicarse() {
	System.out.println("Bote bote...muevelo...Uh, AH!");
		}
	
	@Override
	public void Moverse() {
		System.out.println("Me MUEVO a lo LOCO aunque normalmente camino...Uh, AH!");
	}
	
	@Override
	public void Dormir() {
		System.out.println("Duermo de noche para estar fresco...Uh, AH!");
	}
	
	@Override
	public void Comer() {
		System.out.println("Yo soy onm�voro muchacho...Uh, AH!");
	}
	
	
}
