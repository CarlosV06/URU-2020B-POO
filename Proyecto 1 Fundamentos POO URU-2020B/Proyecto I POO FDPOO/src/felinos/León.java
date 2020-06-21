package felinos;
import animal.Animal;
import interf_comunicar.Comunicar;

public class León extends Animal implements Comunicar {

	public León(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
		
	}

	@Override
	public void Comunicarse() {
		System.out.println("Soy un León...GRRR");
		
	}

	@Override
	public void Moverse() {
		System.out.println("Soy rápido a cuatro patas...GRRR");
		
	}

	@Override
	public void Dormir() {
		System.out.println("De noche no molestes...GRRR");
		
	}

	@Override
	public void Comer() {
		System.out.println("Carne por favor...GRRR");
		
	}

}
