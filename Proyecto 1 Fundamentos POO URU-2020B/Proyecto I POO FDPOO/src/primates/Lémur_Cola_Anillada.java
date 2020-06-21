package primates;
import animal.Animal;
import interf_comunicar.Comunicar;


public class Lémur_Cola_Anillada extends Animal implements Comunicar{

	public Lémur_Cola_Anillada(float Peso, float Altura, String Color) {
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
		System.out.println("Yo soy onmívoro muchacho...Uh, AH!");
	}
	
	
}
