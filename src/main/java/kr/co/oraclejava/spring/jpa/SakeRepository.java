package kr.co.oraclejava.spring.jpa;

import java.util.Collection;
import java.util.List;

public interface SakeRepository {
	
	public Collection<Sake> findAll();
	
	public Sake findOne(int sakeid);
	
	public void create(Sake sake);
	
	public void update(Sake sake);
	
	public void delete(Sake sake);
	
	public SakeType findType(int sakeTypeId);
	
	public Temperature findTemp(int tempId);
	
	public List<SakeType> findAllType();
	
	public List<Temperature> findAllTemp();
}
