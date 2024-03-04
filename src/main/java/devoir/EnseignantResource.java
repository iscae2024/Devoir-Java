package devoir;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/EnseignantApi")
@Produces(MediaType.APPLICATION_JSON)
public class EnseignantResource{
	
	public static Map<Integer, Enseignant> enseignants = new HashMap<Integer, Enseignant>();
	public static int id=0;
	@GET
	public Map<Integer, Enseignant> getDirecteurs(){
		return enseignants;
	}
	@GET
	@Path("/id")
	public Enseignant getDirecteur(@QueryParam("id") int id) {
		return enseignants.get(id);
	}
	@PUT
	public void insert(Enseignant enseignant) {
		enseignant.id = id;
		enseignants.put(id, enseignant);
		id++;
	}
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void update(@FormParam("nameEn") String name, @FormParam("passwordEn") String password, @FormParam("id") int id ) {
		enseignants.remove(id);
		enseignants.put(id, new Enseignant(name, password, id)); 
	}
	@DELETE
	public void delete(@QueryParam("id") int id) {
		enseignants.remove(id);
	}
}
