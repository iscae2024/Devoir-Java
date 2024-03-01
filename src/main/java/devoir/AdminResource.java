package devoir;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;

@Path("/AdminResource")
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

	public static Map<Integer, Admin> admin = new HashMap<Integer, Admin>();
		
	static{
		admin.put(1, new Admin("Admin", "Admin"));
	}
	
	@GET
	public Admin getAdmin() {
		return admin.get(1);
	}
}
