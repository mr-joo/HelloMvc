package kr.co.oraclejava.spring.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDao<PK extends Serializable, T> {
	private Class<T> persitentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		// 제네릭스로 부모클래스가 운용하는 파라메터의 클래스 취득
		this.persitentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@PersistenceContext
	EntityManager entityManger;

	protected EntityManager getEntityManager() {
		return this.entityManger;
	}

	//select
	protected T getByKey(PK key) {
		return (T)entityManger.find(persitentClass, key);
	}
	
	//insert
	protected void persist(T entity) {
		entityManger.persist(entity);
	}	
	
	//update
	protected void upd(T entity) {
		entityManger.merge(entity);
	}
	
	//delete
	protected void del(T entity) {
		entityManger.remove(entityManger.contains(entity)? entity : entityManger.merge(entity));
	}
}
