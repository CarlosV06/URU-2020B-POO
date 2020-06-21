package felinos;
import animal.Animal;
import interf_comunicar.Comunicar;

public class Le�n extends Animal implements Comunicar {

	public Le�n(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
		
	}

	@Override
	public void Comunicarse() {
		System.out.println("Soy un Le�n...GRRR");
		
	}

	@Override
	public void Moverse() {
		System.out.println("Soy r�pido a cuatro patas...GRRR");
		
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
