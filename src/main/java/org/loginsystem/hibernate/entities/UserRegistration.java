package org.loginsystem.hibernate.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String email;
	public String password;
	@OneToOne
	public Address address;
	@OneToMany
	public List<Education> education;
	@OneToMany
	public List<Skill> skill;
	@OneToMany
	public List<Experiance> experiance;
	@OneToMany
	public List<Project> project;
	public String extraCurricular;
	public String about;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getExtraCurricular() {
		return extraCurricular;
	}
	public void setExtraCurricular(String extraCurricular) {
		this.extraCurricular = extraCurricular;
	}
	public List<Education> getEducation() {
		return education;
	}
	public void setEducation(List<Education> education) {
		this.education = education;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Experiance> getExperiance() {
		return experiance;
	}
	public void setExperiance(List<Experiance> experiance) {
		this.experiance = experiance;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", education=" + education + ", skill=" + skill + ", experiance="
				+ experiance + ", project=" + project + ", extraCurricular=" + extraCurricular + ", about=" + about
				+ "]";
	}
	
	
}
