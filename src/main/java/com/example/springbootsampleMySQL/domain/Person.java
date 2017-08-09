package com.example.springbootsampleMySQL.domain;  
  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;  
  
@Entity  
public class Person {  
      
    @Id   
    private Integer id;  
      
    private String name;  
      
    private Integer age;  
      
    private String address;  
  
    public Person() {  
        super();  
    }  
   // @Autowired
    public Person(Integer id, String name, Integer age, String address) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.age = age;  
        this.address = address;  
    }  
  
    public Integer getId() {  
        return id;  
    }  
  
    public void setId(Integer id) {  
        this.id = id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public Integer getAge() {  
        return age;  
    }  
  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
  
    public String getAddress() {  
        return address;  
    }  
  
    public void setAddress(String address) {  
        this.address = address;  
    }  
  
}  