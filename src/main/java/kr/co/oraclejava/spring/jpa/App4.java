package kr.co.oraclejava.spring.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App4 {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		SakeRepository sakeRepository = context.getBean(SakeRepository.class);
		
		Sake hite = sakeRepository.findOne(1);
		sakeRepository.delete(hite);
	}

}
