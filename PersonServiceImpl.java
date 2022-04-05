package com.citi.ex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.citi.ex.dto.Person;
import com.citi.ex.repository.PersonRepository;
@Component("personService") // to do same task as that of Service annotation do
// @Service("personService") // singleton object
public class PersonServiceImpl implements PersonService {

	//to restrict to create only one object
	//how to get single object?
	//solution: Singleton Design Pattern
	//Design Pattern(DP): common solution to a common problem
	
	//here object creation should happen only inside the class
	//if object should be created only inside the class then how can I access it outside the class?
	
	//scope of private would make the scope of the constuctor be only within the class
	private PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	//object creation should happen only inside the class ==>code==>method
	//if object should be create only inside the class then
	//how can we access it outside the class?
	private static PersonService personService; // reference ==> 1 because of static keyword
	//ref==>1 becoz of static keyword

	/*
	public static PersonService getInstance() { //object dependency we have to remove
		//purpose : to get singleton object but the method itself needs 
		//an object to be called..in order to remove object dependecny we add 
		//static keyword
		
		if(personService ==null)
		{
			personService =new PersonServiceImpl();
			return personService;
		}
		return personService;
	}
	*/
	
	@Autowired
	private PersonRepository personRepository;
	@Override
	public String addPerson(Person person) {
		return personRepository.addPerson(person);
	}

	@Override
	public String updatePerson(int personId, Person person) {
		return personRepository.updatePerson(personId, person);
	}

	@Override
	public String deletePerson(int personId) {
		return personRepository.deletePerson(personId);
	}

	@Override
	public Optional<Person> getPerson(int personId) {
		return personRepository.getPersonById(personId);
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.getAllPersons();
	}
	
	

}