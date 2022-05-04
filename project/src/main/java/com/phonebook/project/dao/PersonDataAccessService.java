package com.phonebook.project.dao;

import com.phonebook.project.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("phonebook")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> DB = PersonDataPersistence.readFile("D:\\Downloads\\Documents\\Work\\Phonebook\\project\\database.csv");

    @Override
    public int addPerson(Person person) {
        DB.add(person);
        PersonDataPersistence.writeDB(DB);
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Person selectPersonByName(String name) {
        for (Person person : DB) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person selectPersonByPhone(long number) {
        for (Person person : DB) {
            if (person.getNumber() == number) {
                return person;
            }
        }
        return null;
    }

    @Override
    public int deletePersonByName(String name) {
        for (int i = 0; i < DB.size(); i++) {
            if (DB.get(i).getName().equals(name)) {
                DB.remove(i);
                PersonDataPersistence.writeDB(DB);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int updatePersonByName(String name, long number) {
        for (int i = 0; i < DB.size(); i++) {
            if (DB.get(i).getName().equals(name)) {
                DB.set(i, new Person(name, number));
                PersonDataPersistence.writeDB(DB);
                return 1;
            }
        }
        return 0;
    }
}
