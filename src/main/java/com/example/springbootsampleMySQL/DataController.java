package com.example.springbootsampleMySQL;  
  
import java.util.List;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.domain.Page;  
import org.springframework.data.domain.PageRequest;  
import org.springframework.data.domain.Sort;  
import org.springframework.data.domain.Sort.Direction;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootsampleMySQL.domain.Person;
import com.example.springbootsampleMySQL.repository.PersonRepository;  
  
@RestController  
public class DataController {  
      
    protected static Logger logger=LoggerFactory.getLogger(DataController.class);  
  
    @Autowired  
    PersonRepository personRepository;  
      
    @RequestMapping("/save")  
    public Person save(String name,String address,Integer age){  
        logger.debug("save Start");  
        Person p=personRepository.save(new Person(1,name,age,address));  
        logger.debug("save End");  
        return p;  
    }  
      
    @RequestMapping("/q1")  
    public List<Person> q1(String address){  
        logger.debug("q1 Start");  
        logger.debug("q1 Receive address={}",address);  
        List<Person> people=personRepository.findByAddress(address);  
        return people;  
    }  
      
    @RequestMapping("/q2")  
    public List<Person> q2(String name,String address){  
        logger.debug("q2 Start");  
        logger.debug("q2 Receive name={},address={}",name,address);  
        return personRepository.findByNameAndAddress(name, address);  
    }  
      
    @RequestMapping("/q3")  
    public List<Person> q3(String name,String address){  
        logger.debug("q3 Start");  
        logger.debug("q3 Receive name={},address={}",name,address);  
        return personRepository.withNameAndAddressQuery(name, address);  
    }  
      
    @RequestMapping("/sort")  
    public List<Person> sort(){  
        logger.debug("sort Start");  
        List<Person> people=personRepository.findAll(new Sort(Direction.ASC,"age"));  
        return people;  
    }  
      
    @RequestMapping("/page")  
    public Page<Person> page(){  
        logger.debug("page Start");  
        Page<Person> people=personRepository.findAll(new PageRequest(1,2));  
        return people;  
    }  
}  