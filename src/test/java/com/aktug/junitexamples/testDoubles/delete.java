package com.aktug.junitexamples.testDoubles;

import org.junit.After;
import org.junit.Test;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class delete {

    private Session session = null;

    public class Person {
        String name;
    }

    public class PersonRepository {
        public List<Person> loadBy(Person person) {
            return new ArrayList<Person>();
        }

        public void removePerson(Person person) {

        }
    }

    @Test
    public void returnsPersonWithMatchingType() {
        PersonRepository personRepository = new PersonRepository();

        Person person = new Person();
        person.name = "Name";

        List<Person> people = personRepository.loadBy(person);
        assertNotNull(people);
        assertEquals(1, people.size());
    }

    @After
    public void after() {
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person();
        person.name = "Name";

        personRepository.removePerson(person);

    }


}
