package com.citi.ex;

import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.citi.ex.dto.Person;
import com.citi.ex.service.PersonService;

@SpringBootApplication // to use auto-configuration , component scan 
public class ExApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext applicationContext=
		SpringApplication.run(ExApplication.class, args);
		//PersonService personService=(PersonService)applicationContext.getBean("personService");  // search by name
		//System.out.println(personService.getClass().getName());
		
	//	List <Person>result=personService.getAllPersons();
		//Iterator <Person>itr=result.iterator();
		//while(itr.hasNext()) {
			//Person p=itr.next();
			//System.out.println(p);
		//}
		
		//applicationContext.close();
		
	}

}
