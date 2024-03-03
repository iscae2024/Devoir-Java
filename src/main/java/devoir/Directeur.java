package devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Directeur {
	
	@JsonProperty
	public String name;
	@JsonProperty
	public int id ;
	@JsonProperty
	public String password;
	public Directeur(String name, String password , int id) {
		this.name = name;
		this.password = password;
		this.id = id;
	}
	public Directeur() {
	}
}
