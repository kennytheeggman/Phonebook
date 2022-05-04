package com.phonebook.project.dao;

import com.phonebook.project.model.Person;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonDataPersistence {
    public static void writeDB(List<Person> DB) {
        try {
            FileWriter writer = new FileWriter("D:\\Downloads\\Documents\\Work\\Phonebook\\project\\database.csv");
            for (Person person : DB) {
                String write = person.getName() + "," + person.getNumber() + "\n";
                writer.write(write);
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<Person> readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner in = new Scanner(file);
            List<Person> people = new ArrayList<Person>();
            while (in.hasNextLine()) {
                String[] data = in.nextLine().split(",");
                String name = data[0];
                long number = Long.parseLong(data[1]);
                Person person = new Person(name, number);
                people.add(person);
            }
            return people;
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
            return null;
        }
    }

}
