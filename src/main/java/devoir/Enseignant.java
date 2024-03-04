package devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Enseignant {

	@JsonProperty
	public String name;
	@JsonProperty
	public String password;
	@JsonProperty
	public int id;
	
	public Enseignant(String name,String password,int id) {
		this.name = name;
		this.password = password;
		this.id = id;
	}
	public Enseignant() {
		
	}
}
