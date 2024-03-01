package devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Directeur {
	
	@JsonProperty
	public String name;
	@JsonProperty
	public int id ;

	public Directeur(String name , int id) {
		this.name = name;
		this.id = id;
	}
	public Directeur() {
	}
}
