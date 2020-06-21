package caninos;
import animal.Animal;
import interf_comunicar.Comunicar;

public class Coyote extends Animal implements Comunicar {
		

	public Coyote(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
	
	}
	@Override
	public void Comunicarse() {
	System.out.println("Soy un Coyote...Auuu...");
		}
	
	@Override
	public void Moverse() {
		System.out.println("Me muevo en cuatro patas...Auuu...");
	}
	
	@Override
	public void Dormir() {
		System.out.println("Duermo de noche y algunas veces de día...Auuu");
	}
	
	@Override
	public void Comer() {
		System.out.println("Soy carnivoro...¿tienes carne?..Auuu...");
	}
	
	
	
	
	
	}




