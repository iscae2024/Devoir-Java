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

@Path("/DirecteurApi")
@Produces(MediaType.APPLICATION_JSON)
public class DirecteurResource {
	
	public static Map<Integer, Directeur> directeurs = new HashMap<Integer, Directeur>();
	public static int id = 0;
	@GET
	public Map<Integer, Directeur> getDirecteurs(){
		return directeurs;
	}
	@GET
	@Path("/id")
	public Directeur getDirecteur(@QueryParam("id") int id) {
		return directeurs.get(id);
	}
	@PUT
	public void insert(Directeur directeur) {
		directeur.id = id;
		directeurs.put(id, directeur);
		id++;
	}
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void update(@FormParam("nameDr") String name,@FormParam("passwordDr") String password, @FormParam("id") int id ) {
		directeurs.remove(id);
		directeurs.put(id, new Directeur(name, password , id)); 
	}
	
	@DELETE
	public void delete(@QueryParam("id") int id) {
		directeurs.remove(id);
	}
}
