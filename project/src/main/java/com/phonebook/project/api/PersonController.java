package com.phonebook.project.api;

import com.phonebook.project.model.Person;
import com.phonebook.project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequestMapping("/api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "name={name}")
    public Person getPersonByName(@PathVariable("name") String name) {
        return personService.getPersonByName(URLDecoder.decode(name, StandardCharsets.UTF_8));
    }

    @GetMapping(path = "phone={phone}")
    public Person getPersonByPhone(@PathVariable("phone") int number) {
        return personService.getPersonByPhone(number);
    }

    @DeleteMapping(path = "name={name}")
    public void deletePersonByName(@PathVariable("name") String name) {
        personService.deletePersonByName(URLDecoder.decode(name, StandardCharsets.UTF_8));
    }

    @PutMapping(path = "name={name}")
    public void updatePersonByName(@PathVariable("name") String name, @RequestBody Person person) {
        personService.updatePersonByName(URLDecoder.decode(name, StandardCharsets.UTF_8), person.getNumber());
    }
}
