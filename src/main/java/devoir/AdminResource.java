package devoir;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/AdminResource")
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

	public static Map<Integer, Admin> admin = new HashMap<Integer, Admin>();
		
	static{
		admin.put(1, new Admin("Admin", "Admin"));
	}
	
	@GET
	public Map<Integer, Admin> getAdmin() {
		return admin;
	}
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void changePassword(@FormParam("password") String password) {
		admin.clear();
		admin.put(1, new Admin("Admin", password)); 
	}
}
