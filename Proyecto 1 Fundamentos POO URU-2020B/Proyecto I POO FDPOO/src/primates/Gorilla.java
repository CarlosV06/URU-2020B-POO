package primates;
import animal.Animal;
import interf_comunicar.Comunicar;

public class Gorilla extends Animal implements Comunicar {

	public Gorilla(float Peso, float Altura, String Color) {
		super(Peso, Altura, Color);
	
	}
	@Override
	public void Comunicarse() {
	System.out.println("Soy un Gorilla...Uh,Uh...");
		}
	
	@Override
	public void Moverse() {
		System.out.println("Utilizo mis brazos para tener equilibrio...Uh,Uh...");
	}
	
	@Override
	public void Dormir() {
		System.out.println("Duermo mucho en la noche...Uh,Uh");
	}
	
	@Override
	public void Comer() {
		System.out.println("Me gustan las frutas pero algunas veces como insectos...Uh,Uh");
	}
	
	
}
