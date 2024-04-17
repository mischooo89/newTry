package com.javarush.lectures.mvc_demo;

public interface PersonService {

    public Person saveUpdatePerson (Person person);
    public Person findPersonById(Integer id);
}
