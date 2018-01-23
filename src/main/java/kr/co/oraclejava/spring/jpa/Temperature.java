package kr.co.oraclejava.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Temperature {
	
	@Id
	private int id;
	private String temperature;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTemp() {
		return temperature;
	}
	
	public void setTemp(String temperature) {
		this.temperature = temperature;
	}
}
