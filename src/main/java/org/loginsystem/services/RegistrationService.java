package org.loginsystem.services;

import java.util.List;

import org.loginsystem.hibernate.DAO.RegistrationDAO;
import org.loginsystem.hibernate.entities.UserRegistration;


public class RegistrationService {

	public void addUser(UserRegistration registration)
	{
		RegistrationDAO reg = new RegistrationDAO();
		reg.addUser(registration);
	}

	public UserRegistration getUser() {
		RegistrationDAO reg = new RegistrationDAO();
		UserRegistration list =reg.GetAll();	
		return list;
	}
}
