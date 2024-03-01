package devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Enseignant {

	@JsonProperty
	public String name;
	@JsonProperty
	public int id;
	
	public Enseignant(String name,int id) {
		this.name = name;
		this.id = id;
	}
}
