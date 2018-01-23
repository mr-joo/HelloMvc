package kr.co.oraclejava.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SakeType {
	@Id
	private int id;
	
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
