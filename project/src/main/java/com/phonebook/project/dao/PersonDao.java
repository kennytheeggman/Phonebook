package com.phonebook.project.dao;

import com.phonebook.project.model.Person;

import java.util.List;

public interface PersonDao {

    int addPerson(Person person);

    List<Person> selectAllPeople();

    Person selectPersonByName(String name);

    Person selectPersonByPhone(long number);

    int deletePersonByName(String name);

    int updatePersonByName(String name, long number);

}
