package br.com.curso.services;


import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.exceptions.ResourceNotFoundException;
import br.com.curso.model.Person;
import br.com.curso.repositories.PersonRepository;

@Service
public class PersonServices {
    
   
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){

        logger.info("Finding All people!");
      
        return repository.findAll();
    }

   

    public Person findById(Long id){

        logger.info("Finding one person!");
        
       return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID") );
    }


    
    public Person create (Person person) {
       logger.info("Creating one Person!");
       return repository.save(person);
 
    }



    public Person update(Person person) {
       
       Person entity = repository.findById(person.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLatsName(person.getLatsName());
        entity.setAddressName(person.getAddressName());
        entity.setGender(person.getGender());

        return repository.save(person);
    }



    public void delete(Long id) {
        Person entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

      repository.delete(entity);
    }



    }

