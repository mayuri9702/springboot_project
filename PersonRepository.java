package com.citi.ex.repository;

import java.util.List;
import java.util.Optional;

import com.citi.ex.dto.Person;

public interface PersonRepository {
	public String addPerson(Person person);
	public String updatePerson(int personId, Person person);
	public String deletePerson(int personId);
	public Optional<Person> getPersonById(int personId);
	public List<Person> getAllPersons();
}