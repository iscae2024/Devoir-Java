package devoir;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/EnseignantApi")
@Produces(MediaType.APPLICATION_JSON)
public class EnseignantResource{
	
	public static Map<Integer, Enseignant> enseignants = new HashMap<Integer, Enseignant>();

	@GET
	public Map<Integer, Enseignant> getDirecteurs(){
		return enseignants;
	}
}
