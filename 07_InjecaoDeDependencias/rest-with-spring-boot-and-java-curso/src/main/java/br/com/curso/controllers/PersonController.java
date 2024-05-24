package br.com.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import br.com.curso.model.Person;
import br.com.curso.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public Person findById(@PathVariable(value = "id") String id) {

	return service.findById(id);
	}
	
	@RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	
	public List <Person> findAll()  {

	return service.findAll();
	}
	
	@RequestMapping( method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE , 
	produces = MediaType.APPLICATION_JSON_VALUE)
	
	public Person create(@RequestBody Person person)  {

	return service.create(person);
	}

}
