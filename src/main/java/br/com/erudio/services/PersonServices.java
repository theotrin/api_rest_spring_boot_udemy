package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong couter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("finding one person");
        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirsName("Theo");
        person.setLastName("Trindade");
        person.setAddress("Curitiba - Parana - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();

        for (int c = 0; c < 9; c++){
            persons.add( mockPerson(c));
        }
        return persons;
    }

    public Person create(Person person) {
        person.setId(couter.incrementAndGet());
        return person;
    }

    public Person update(Person person) {
        person.setId(couter.incrementAndGet());
        return person;
    }

    public void delete(String id) {

    }

    private Person mockPerson(Integer c) {
        Person person = new Person();
        person.setId(couter.incrementAndGet());
        person.setFirsName("Person name " + c);
        person.setLastName("Person last name " + c);
        person.setAddress("Curitiba - Parana - Brasil");
        person.setGender("Non Binary");
        return person;
    }
}
