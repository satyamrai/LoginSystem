package org.loginsystem.hibernate.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.loginsystem.hibernate.entities.Address;
import org.loginsystem.hibernate.entities.Education;
import org.loginsystem.hibernate.entities.Experiance;
import org.loginsystem.hibernate.entities.Project;
import org.loginsystem.hibernate.entities.Skill;
import org.loginsystem.hibernate.entities.Stream;
import org.loginsystem.hibernate.entities.UserRegistration;
import org.loginsystem.hibernate.entities.YearOfExperiance;;


public class RegistrationDAO {

		Configuration configuration = new Configuration()
				.configure().addAnnotatedClass(Address.class)
				.addAnnotatedClass(Education.class)
				.addAnnotatedClass(Experiance.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Skill.class)
				.addAnnotatedClass(Stream.class)
				.addAnnotatedClass(UserRegistration.class)
				.addAnnotatedClass(YearOfExperiance.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Address address = new Address();
		Education education = new Education();
		List<Education> educationList = new ArrayList<Education>();
		Experiance experiance = new Experiance();
		List<Experiance> experianceList = new ArrayList<Experiance>();
		Project project = new Project();
		List<Project> projectList = new ArrayList<Project>();
		Skill skill = new Skill();
		List<Skill> skillList = new ArrayList<Skill>();
		Stream stream = new Stream();
		List<Stream> streamList = new ArrayList<Stream>();
		UserRegistration userregistration = new UserRegistration();
		YearOfExperiance yearOfExperiance = new YearOfExperiance();
		
		public void addUser(UserRegistration registration) {
			session.getTransaction().begin();
			
			//Address
			address.setAddressLine1("H");
			address.setAddressLine2("g");
			address.setStreet1("ab");
			address.setStreet2("xyz");
			address.setDistrict("ghazipur");
			address.setState("Up");
			address.setPostalCode(123);
			address.setCountry("India");
			
			//Stream
			stream.setName("12");
			streamList.add(stream);
			
			//Education
			education.setCollegeName("LPU");
			education.setPercentage(78);
			education.setStream(streamList);
			educationList.add(education);
			
			//YearOfExperiance
			yearOfExperiance.setStartDate("12/12/12");
			yearOfExperiance.setEndDate("14/12/20");
			
			//Experiance
			experiance.setName("kk");
			experiance.setPosition("developer");
			experiance.setYearOfExperiance(yearOfExperiance);
			experianceList.add(experiance);
			
			//Project
			project.setName("star");
			project.setDescription("hello world");
			project.setLink("hello link");
			projectList.add(project);
			
			//Skill 
			skill.setName("Java");
			skill.setProficiency("Intermediate");
			skillList.add(skill);
		
			
			userregistration.setName("username");
			userregistration.setEmail("abc@abc.com");
			userregistration.setAddress(address);
			userregistration.setExtraCurricular("ExtraCurricular");
			userregistration.setAbout("about");
			userregistration.setSkill(skillList);
			userregistration.setExperiance(experianceList);
			userregistration.setEducation(educationList);
			userregistration.setProject(projectList);
			//userregistration.set
			session.save(userregistration);
			session.save(address);
			session.save(project);
			session.save(education);
			session.save(experiance);
			session.save(skill);
			session.save(yearOfExperiance);
			session.save(stream);
			//session.save(object)
			session.getTransaction().commit();
			session.close();

		}			
		public UserRegistration GetAll(){
			Session session = factory.getCurrentSession();
			session.getTransaction().begin();
			UserRegistration userData = (UserRegistration) session.get(UserRegistration.class, 1);
			return userData;	
		}
}
