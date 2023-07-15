package org.example;

import org.example.dao.PersonDao;
import org.example.model.Person;
import org.example.model.Rule;

public class Main {
    public static void main(String[] args) {
        var personDao = new PersonDao();
        var person = new Person("Mahan", "Jabani", 88, Rule.CLERK, Rule.CLERK);
        personDao.saveStudent(person);
        System.out.println("Hello world!");
    }
}