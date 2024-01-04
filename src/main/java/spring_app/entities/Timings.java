package spring_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="timings")
public class Timings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timingsId;
	private String morning;
	private String afternoon;
	private String evening;
	public int getTimingsId() {
		return timingsId;
	}
	public void setTimingsId(int timingsId) {
		this.timingsId = timingsId;
	}
	public String getMorning() {
		return morning;
	}
	public void setMorning(String morning) {
		this.morning = morning;
	}
	public String getAfternoon() {
		return afternoon;
	}
	public void setAfternoon(String afternoon) {
		this.afternoon = afternoon;
	}
	public String getEvening() {
		return evening;
	}
	public void setEvening(String evening) {
		this.evening = evening;
	}
	
	

}
