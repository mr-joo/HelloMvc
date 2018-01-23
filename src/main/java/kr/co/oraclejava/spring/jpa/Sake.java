package kr.co.oraclejava.spring.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Sake {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotBlank	//공백이나 null이면 NG(좌우 공백은 무시된다)
	private String brand;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="type_id")
	private SakeType sakeType;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="sake_id")
	private List<Impression> impressions;
	
	public List<Impression> getImpressions() {
		return impressions;
	}

	public void setImpressions(List<Impression> impressions) {
		this.impressions = impressions;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public SakeType getSakeType() {
		return sakeType;
	}
	
	public void setSakeType(SakeType sakeType) {
		this.sakeType = sakeType;
	}
}
