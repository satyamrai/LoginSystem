package org.loginsystem.hibernate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Experiance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String position;
	@OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	public YearOfExperiance yearOfExperiance;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public YearOfExperiance getYearOfExperiance() {
		return yearOfExperiance;
	}
	public void setYearOfExperiance(YearOfExperiance yearOfExperiance) {
		this.yearOfExperiance = yearOfExperiance;
	}
	@Override
	public String toString() {
		return "Experiance [id=" + id + ", name=" + name + ", position=" + position + ", yearOfExperiance="
				+ yearOfExperiance + "]";
	}
	
}
