package me.zogodo.ssh.service;

import java.util.List;


import me.zogodo.ssh.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.zogodo.ssh.dao.PersonDAO;

@Transactional
@Service
public class PersonService
{

    @Autowired
    public PersonDAO personDAO;

    public void addPerson(Person person)
    {
        personDAO.addPerson(person);
    }

    public void deletePersonById(int id)
    {
        personDAO.deletePersonById(id);
    }

    public void updatePerson(Person person)
    {
        personDAO.updatePerson(person);
    }

    public Person getPersonById(int id)
    {
        return personDAO.getPersonById(id);
    }

    public Person getPersonByName(String name)
    {
        return personDAO.getPersonByName(name);
    }

    public List<Person> getPersons()
    {
        return personDAO.getAllPersons();
    }

    public List<Person> find(String sql)
    {
        return personDAO.find(sql);
    }
}
