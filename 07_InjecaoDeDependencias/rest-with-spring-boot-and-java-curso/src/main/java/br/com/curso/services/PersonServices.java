package br.com.curso.services;


import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.exceptions.ResourceNotFoundException;
import br.com.curso.mapper.DozerMapper;
import br.com.curso.model.Person;
import br.com.curso.repositories.PersonRepository;
import br.com.curso.vov1.PersonVO;


@Service
public class PersonServices {
    
   
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    
    @Autowired
    PersonRepository repository;

    

    public List<PersonVO> findAll(){

        logger.info("Finding All people!");
      
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
    }

   

    public PersonVO findById(Long id){

        logger.info("Finding one person!");
        
       var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID") );
        return DozerMapper.parseObject(entity, PersonVO.class);
    }


    
    public PersonVO create (PersonVO person) {
       logger.info("Creating one PersonVO!");

        var entity = DozerMapper.parseObject(person ,Person.class);
         var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

         return vo;
 
    }



    public PersonVO update(PersonVO personVO) {
       
       var entity = repository.findById(personVO.getId())
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddressName(personVO.getAddressName());
        entity.setGender(personVO.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }



    public void delete(Long id) {
        var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

         repository.delete(entity);
    }



    }

