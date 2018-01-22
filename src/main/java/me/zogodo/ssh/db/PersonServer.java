package me.zogodo.ssh.db;

import me.zogodo.ssh.entity.Person;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zogodo on 18-1-22.
 */
@Repository
@Transactional
@Service
public class PersonServer
{
    public static PersonServer me = new PersonServer();

    private PersonServer(){}

    public List<Person> find(String sql)
    {
        return null;
    }

    public void addPerson(Person person)
    {
        ;
    }

    public void deletePersonById(int id)
    {
        ;
    }

    public void updatePerson(Person person)
    {
        ;
    }

    public Person getPersonById(int id)
    {
        return null;
    }

    public Person getPersonByName(String name)
    {
        return null;
    }

    public List<Person> getAllPersons()
    {
        return null;
    }
}
