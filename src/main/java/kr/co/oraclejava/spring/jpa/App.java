package kr.co.oraclejava.spring.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		SakeRepository sakeRepository = context.getBean(SakeRepository.class);
		
		for (Sake sake : sakeRepository.findAll()) {
			System.out.println(sake.getBrand() + "," + sake.getSakeType().getType());
			for(Impression imp : sake.getImpressions()) {
				System.out.printf("temp : %s", imp.getTemperature().getTemp());
				System.out.printf("\n�냼媛�: %s\n", imp.getImpression());
				System.out.println("------------------------");
			}
		}
	}

}
