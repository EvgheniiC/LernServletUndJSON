package service;

import domain.Person;

public interface PersonService {
    void savePerson(Person person);

    void findAllPerson();

    void deletePerson(Person person);

    boolean isPersonExists(String name);

}
