package felinos;
import animal.Animal;
import interf_comunicar.Comunicar;

public class Tigre extends Animal implements Comunicar {
	public Tigre(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
		
	}

	@Override
	public void Comunicarse() {
		System.out.println("Grarr...Soy un Tigre...");
		
	}

	@Override
	public void Moverse() {
		System.out.println("Me muevo en cuatro patas y soy rápido...Grarr...");
		
	}

	@Override
	public void Dormir() {
		System.out.println("Duermo de noche...Grarr...");
		
	}

	@Override
	public void Comer() {
		System.out.println("Soy Carnívoro...carne...Grarr...");
		
	}

}
