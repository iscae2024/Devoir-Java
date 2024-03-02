package devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin {

	@JsonProperty
	public String password;
	@JsonProperty
	public String name;
	public Admin(String name,String pass) {
		this.name = name;
		this.password = pass;
	}
	public Admin() {
		
	}
	
}
