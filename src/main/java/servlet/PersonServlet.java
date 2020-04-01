package servlet;

import domain.Gender;
import domain.Person;
import service.PersonService;
import service.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PersonService personService = new PersonServiceImpl();

        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");


        if (personService.isPersonExists(name)) {//без else
            Person person = new Person();
            person.setName(name);
            person.setPassword(password);
            person.setGender(Gender.valueOf(gender));
            personService.savePerson(person);
            writer.println("Person with Name " + name + " with password " + password + " was register");
        } else {
            writer.println(" Person already exists ");
        }



        personService.findAllPerson();


    }
}
