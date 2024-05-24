package br.com.curso.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.curso.model.Person;

@Service
public class PersonServices {
    
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){

        logger.info("Finding All people!");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++ ){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

   

    public Person findById(String id){

        logger.info("Finding one person!");
         
       Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLatsName("Melo");
        person.setAddressName("Recife - Pernambuco");
        person.setGender("Male");
       return person;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First name: " + i);
        person.setLatsName("Last name : " +  i);
        person.setAddressName("Address: " + i);
        person.setGender("Male");
       return person;
    }
    public Person create (Person person) {
       logger.info("Creating one Person!");
       return person;
    }
}
