package kr.co.oraclejava.spring.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3 {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		SakeRepository sakeRepository = context.getBean(SakeRepository.class);
		
		Sake hite = sakeRepository.findOne(1);
		Temperature temp = sakeRepository.findTemp(7);
		
		Impression imp = new Impression();
		imp.setTemperature(temp);
		imp.setImpression("�븯�씠�듃 �뿊�뒪�듃�씪 肄쒕뱶");
		List<Impression> impList = hite.getImpressions();
		impList.add(imp);
		
		sakeRepository.update(hite);
	}

}
