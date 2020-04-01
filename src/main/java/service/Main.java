package service;

import domain.Gender;
import domain.Person;

public class Main {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        Person vasia = new Person();
        vasia.setName("Vasia");
        vasia.setPassword("12345");
        vasia.setGender(Gender.MAN);

        Person petia = new Person();
        petia.setName("Petia");
        petia.setPassword("1234534");
        petia.setGender(Gender.MAN);

        Person fedia = new Person();
        fedia.setName("Fedia");
        fedia.setPassword("00012345");
        fedia.setGender(Gender.MAN);

        personService.savePerson(petia);
        personService.savePerson(vasia);
        personService.savePerson(fedia);

       if (personService.isPersonExists("Fedia")){
           Person fedia1 = new Person();
           fedia1.setName("Fedia");
           fedia1.setPassword("00012345");
           fedia1.setGender(Gender.MAN);

           personService.savePerson(fedia1);

       } else {
           System.out.println("Exists");
       }




        personService.findAllPerson();
    }
}
