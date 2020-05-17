package org.loginsystem.hibernate.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class YearOfExperiance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String startDate;
	public String endDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "YearOfExperiance [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
