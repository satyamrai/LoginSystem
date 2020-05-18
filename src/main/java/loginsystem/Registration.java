package loginsystem;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.loginsystem.hibernate.entities.UserRegistration;
import org.loginsystem.services.RegistrationService;

@Path("registration")
public class Registration {

	
	  
	  @POST
	  @Path("user")
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_JSON)
	  public void AddNewUser(UserRegistration registration) {
	  new RegistrationService().addUser(registration); 
	  }
	 
	
	@GET
	@Path("user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserRegistration getUser(@PathParam("id") int id){
		RegistrationService reg = new RegistrationService();
		UserRegistration list = reg.getUser(id);
		return list;
	}
}
