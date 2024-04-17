package com.javarush.lectures.mvc_demo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
public class Person  {
    private Integer id;
    private String name;

    public Person(Integer id, String name){
        this.id = id;
        this.name = name;
    }

  public Integer getId() {
      return id;
  }
  
  public String getName(){
        return name;
  }
  
  public void setId(Integer id){
        this.id = id;
  }
  
  public void setName(String name){
        this.name = name;
  }

}
