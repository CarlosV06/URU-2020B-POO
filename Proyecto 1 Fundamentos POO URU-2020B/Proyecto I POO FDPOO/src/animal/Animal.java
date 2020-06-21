package animal;

public abstract class Animal {
	//Atributos
	private float Peso, Altura;
	private String Color,CAnimal,TipoAnimal;
	//Constructor
	public Animal (float Peso, float Altura, String Color) {
		this.Peso = Peso;
		this.Altura = Altura;
		this.Color = Color;
	}
	
	//Método set y get para Clase de Animal y Tipo de Animal
	
	public void setCAnimal(String CAnimal) {
		this.CAnimal = CAnimal;
	}
	public String getCAnimal(){
		return CAnimal;
		}
	public void setTipoAnimal(String TipoAnimal ) {
		this.TipoAnimal = TipoAnimal;
	}
	public String getTipoAnimal () {
		return TipoAnimal;
	}
	
	
	//Métodos
	public abstract void Moverse();
	public abstract void Dormir();
	public abstract void Comer();
	
	public String toString() {
		return "\n-Tipo de animal: "    + this.getTipoAnimal() +      "   -Clase de Animal: "   + this.getCAnimal() + "   -Peso: Kg " + Peso + "   -Tamaño: Cm " + Altura + "   -Color: " + Color;
	}
	
	}
