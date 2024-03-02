package devoir;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/CoursApi")
@Produces(MediaType.APPLICATION_JSON)
public class CoursResource {
	public static Map<Integer, Cours> listCours = new HashMap<Integer, Cours>();
	public static int id = 0;
	@GET
	public Map<Integer, Cours> getCourses(){
		return listCours;
	}
	@PUT
	public void insert(Cours cours) {
		cours.id = id;
		listCours.put(id, cours);
		id++;
	}
}
