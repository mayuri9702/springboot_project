package com.citi.ex.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citi.ex.dto.Person;
import com.citi.ex.service.PersonService;

@RestController
@CrossOrigin("*")  // give support to any cross domain
@RequestMapping("/api/person")   // should start with /api/person
public class PersonController {
	@Autowired
	PersonService personService;
	@PostMapping("/add") // to create any new record/insert
	// we should use http's post method
	// to handle the post method in rest we have @PostMapping
	public String addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable("id")int id) {
		Optional<Person>optional= personService.getPerson(id);
		if(optional.isPresent())
			return optional.get();
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable("id") int id) {
		return personService.deletePerson(id);
	}
	
	@PutMapping("{id}")
	public String updatePerson(@PathVariable("id")int id,Person person) {
		return personService.updatePerson(id, person);
	}
	
	@GetMapping()
	public List<Person> getPersons(){
		return personService.getAllPersons();
	}
	
}
