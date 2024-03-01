package devoir;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/DirecteurApi")
@Produces(MediaType.APPLICATION_JSON)
public class DirecteurResource {
	
	public static Map<Integer, Directeur> directeurs = new HashMap<Integer, Directeur>();
	
	@GET
	public Map<Integer, Directeur> getDirecteurs(){
		return directeurs;
	}
	
}
