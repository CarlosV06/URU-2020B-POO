package caninos;
import interf_comunicar.Comunicar;
import animal.Animal;

public class Zorro_Culpeo extends Animal implements Comunicar {
	public Zorro_Culpeo (float Peso, float Altura, String Color){
		super(Peso, Altura, Color);
	}
	@Override
	public void Comunicarse() {
		System.out.println("Soy un Zorro Culpeo...Auuo...");
	}
	
	@Override
	public void Comer() {
		System.out.println("Prefiero la carne pero algunas veces como plantas...Auuo...");
	}
	
	@Override
	public void Moverse() {
		System.out.println("Me muevo en cuatro patas...Auuo...");
	}
	@Override
	public void Dormir() {
		System.out.println("Duermo mucho...de noche...Auuo");
	}
}
