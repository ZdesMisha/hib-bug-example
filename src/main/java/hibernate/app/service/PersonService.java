package hibernate.app.service;

import hibernate.app.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by kharkov on 30.01.17.
 */

public class PersonService {

    private static EntityManager entitymanager;

    static {
        entitymanager = Persistence.createEntityManagerFactory("h2-jpa").createEntityManager();
    }

    public void save(Person person) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(person);
        entitymanager.getTransaction().commit();
    }

}
