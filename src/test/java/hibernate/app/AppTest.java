package hibernate.app;

import hibernate.app.entity.Cat;
import hibernate.app.entity.Person;
import hibernate.app.service.PersonService;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private PersonService personService;

    private static Person createPerson() {
        Person person = new Person("Spock");

        Cat cat1 = new Cat("John");
        Cat cat2 = new Cat("Persey");

        List<Cat> cats = new ArrayList<Cat>();
        cats.add(cat1);
        cats.add(cat2);
        person.setCats(cats);

        return person;
    }

    @Before
    public void prepare() {
        personService = new PersonService();
    }


    /**
     * This test SHOULD FAIL with ConstraintViolationException but it doesn't
     */

    @Test
    public void personUpdateTest() {
        Person person = createPerson();

        /**
         * create new person
         */

        personService.save(person);

        /**
         * change cats List size to break constraint
         */
        person.setCats(new ArrayList<Cat>());

        /**
         * update person. constrain violation expected
         */

        personService.save(person);
    }
}
