package org.example;

import org.example.dao.PersonDao;
import org.example.model.Person;

public class Main {
    public static void main(String[] args) {
        var personDao = new PersonDao();
        var person = new Person("Mahan", "Jabani", 56);
        personDao.saveStudent(person);
        System.out.println("Hello world!");
    }
}