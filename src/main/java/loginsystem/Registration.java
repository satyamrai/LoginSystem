package loginsystem;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.loginsystem.hibernate.entities.UserRegistration;
import org.loginsystem.services.RegistrationService;

@Path("registration")
public class Registration {

	/*
	 * @GET
	 * 
	 * @Path("userdata")
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String GetUserData() {
	 * UserRegistration registration = new UserRegistration(); RegistrationService
	 * reg = new RegistrationService(); reg.addUser(registration); return
	 * "This user data"; }
	 */
	
	@GET
	@Path("user")
	@Produces(MediaType.APPLICATION_JSON)
	public UserRegistration getUser(){
		RegistrationService reg = new RegistrationService();
		UserRegistration list = reg.getUser();
		return list;
	}
}
