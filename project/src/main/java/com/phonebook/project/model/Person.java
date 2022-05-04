package com.phonebook.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final String name;
    private final long number;

    public Person(@JsonProperty("name") String name,
                  @JsonProperty("number") long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }
}
