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

    public static final PersonService PERSON_SERVICE = new PersonServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        String message = " Person already exists ";

        if (!PERSON_SERVICE.isPersonExists(name)) {
            Gender gender1 = Gender.valueOf(gender);
            Person person = new Person(name, password, gender1);
            PERSON_SERVICE.savePerson(person);
            message = "Person with Name " + name + " with password " + password + " was register";
        }

        writer.println(message);



        PERSON_SERVICE.findAllPerson();

        /*BufferedReader reader = req.getReader();

        Gson gson = new Gson();

        Person person = gson.fromJson(reader, Person.class);

        PrintWriter writer = resp.getWriter();

        writer.println("Person with Name " + person.getName() + " with password " + person.getPassword() + " was register");*/

    }
}
