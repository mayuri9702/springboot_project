package com.citi.ex.service;

import java.util.List;
import java.util.Optional;

import com.citi.ex.dto.Person;

public interface PersonService {

	public String addPerson(Person person);
	public String updatePerson(int personId,Person person);
	public String deletePerson(int personId);
	public Optional<Person> getPerson(int personId); // to retrieve the single object
	public List<Person> getAllPersons(); // it will retrieve all object
	
}
// interface - its a contract
