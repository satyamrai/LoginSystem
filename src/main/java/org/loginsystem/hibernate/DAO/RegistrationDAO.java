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
			
		
		  address.setAddressLine1(registration.getAddress().getAddressLine1()); 
		  address.setAddressLine2(registration.getAddress().getAddressLine2());
		  address.setStreet1(registration.getAddress().getStreet1()); 
		  address.setStreet2(registration.getAddress().getStreet2());
		  address.setDistrict(registration.getAddress().getDistrict());
		  address.setState(registration.getAddress().getState());
		  address.setPostalCode(registration.getAddress().getPostalCode());
		  address.setCountry(registration.getAddress().getCountry());
		  
		  
		  //Stream
		  stream.setName(registration.getEducation().get(registration.getId()).getStream().get(registration.getId()).getName());
		  streamList.addAll(registration.getEducation().get(registration.getId()).getStream());
		
		  //Education 
		  education.setCollegeName(registration.getEducation().get(registration.getId()).getCollegeName()); 
		  education.setPercentage(registration.getEducation().get(registration.getId()).getPercentage());
		  education.setStream(streamList);
		  educationList.add(education);
		  
		  //YearOfExperiance
		  yearOfExperiance.setStartDate(registration.getExperiance().get(registration.getId()).getYearOfExperiance().getStartDate());
		  yearOfExperiance.setEndDate(registration.getExperiance().get(registration.getId()).getYearOfExperiance().getEndDate());
		  
		  //Experiance 
		  experiance.setName(registration.getExperiance().get(registration.getId()).getName()); 
		  experiance.setPosition(registration.getExperiance().get(registration.getId()).getPosition());
		  experiance.setYearOfExperiance(yearOfExperiance);
		  experianceList.add(experiance);
		  
		  //Project
		  project.setName(registration.getProject().get(registration.getId()).getName()); 
		  project.setDescription(registration.getProject().get(registration.getId()).getDescription());
		  project.setLink(registration.getProject().get(registration.getId()).getLink());
		  projectList.add(project);
		  
		  //Skill 
		  skill.setName(registration.getSkill().get(registration.getId()).getName()); 
		  skill.setProficiency(registration.getSkill().get(registration.getId()).getProficiency());
		  skillList.add(skill);
		  
		  
		  userregistration.setName(registration.getName());
		  userregistration.setEmail(registration.getEmail());
		  userregistration.setAddress(address);
		  userregistration.setExtraCurricular(registration.getExtraCurricular());
		  userregistration.setAbout(registration.getAbout()); 
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
			

		}			
		public UserRegistration GetUserWithId(int id){
			Session session = factory.openSession();
			session.getTransaction().begin();
			UserRegistration userData = (UserRegistration) session.get(UserRegistration.class, id);
			session.close();
			return userData;	
		}
}
