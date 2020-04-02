package service;

import domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList;

    public PersonServiceImpl() {
        personList = new ArrayList<>();
    }

    public boolean isPersonExists(String name) {
   /*     for (Person p : personList) {
            if (p.getName().equals(name)) {
                return false;
            }
        }
        return true;*/

       return personList.stream().anyMatch(p -> p.getName().equals(name));
    }

    public void savePerson(Person person) {
        personList.add(person);
    }

    public void findAllPerson() {
       /* for (Person p : personList) {
            System.out.println(p.getName());
        }*/
        personList.forEach(person -> System.out.println(person.getName()));
    }

    @Override
    public void deletePerson(Person person) {
        personList.remove(person);
    }
}

