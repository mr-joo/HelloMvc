package kr.co.oraclejava.spring.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		SakeRepository sakeRepository = context.getBean(SakeRepository.class);
		
		Sake cloud = new Sake();
		
		SakeType beer = sakeRepository.findType(2);
		cloud.setSakeType(beer);
		cloud.setBrand("클라우드");
		sakeRepository.create(cloud);
	}

}
