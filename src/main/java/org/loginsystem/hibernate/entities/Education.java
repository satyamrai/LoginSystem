package org.loginsystem.hibernate.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity(name="Education")
@Table(name="Education")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Stream> stream;
	public String collegeName;
	public double percentage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Stream> getStream() {
		return stream;
	}
	public void setStream(List<Stream> stream) {
		this.stream = stream;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", stream=" + stream + ", collegeName=" + collegeName + ", percentage="
				+ percentage + "]";
	}
	
	
}
