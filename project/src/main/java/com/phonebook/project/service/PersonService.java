package com.phonebook.project.service;

import com.phonebook.project.dao.PersonDao;
import com.phonebook.project.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("phonebook") PersonDao personDao) {
        this.personDao = personDao;
    }

    public long addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Person getPersonByName(String name) {
        return personDao.selectPersonByName(name);
    }

    public Person getPersonByPhone(long number) {
        return personDao.selectPersonByPhone(number);
    }

    public long deletePersonByName(String name) {
        return personDao.deletePersonByName(name);
    }

    public long updatePersonByName(String name, long number) {
        return personDao.updatePersonByName(name, number);
    }
}
