package kr.co.oraclejava.spring.jpa;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SakeRepositoryImpl extends AbstractDao<Integer, Sake> implements SakeRepository {

	@Override
	public Collection<Sake> findAll() {
		//Entity�뒗 ���냼臾몄옄 援щ텇. �씪遺�留� �젒洹쇳븯怨� �떢�쓣 �븣 s.�쑝濡� ��. jpql?
		//"SELECT s FROM Sake s where s.sakeType.type='留μ＜'"
		List<Sake> sakes = getEntityManager().createQuery("SELECT s FROM Sake s").getResultList();
		return sakes;
	}

	@Override
	public Sake findOne(int sakeid) {
		return getByKey(sakeid);
	}

	@Override
	@Transactional
	public void create(Sake sake) {
		persist(sake);	//臾댁“嫄� �깉濡쒖슫 媛앹껜瑜� 留뚮뱾�뼱以�
	}

	@Override
	@Transactional
	public void update(Sake sake) {
		upd(sake);
	}

	@Override
	@Transactional
	public void delete(Sake sake) {
		del(sake);
	}

	@Override
	public SakeType findType(int sakeTypeId) {
		return getEntityManager().find(SakeType.class, sakeTypeId);
	}

	@Override
	public Temperature findTemp(int tempId) {
		return getEntityManager().find(Temperature.class, tempId);
	}

	@Override
	public List<SakeType> findAllType() {
		return getEntityManager().createQuery("from SakeType").getResultList();
	}

	@Override
	public List<Temperature> findAllTemp() {
		return getEntityManager().createQuery("from Temperature").getResultList();
	}

}
