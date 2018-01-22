package me.zogodo.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import me.zogodo.ssh.entity.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO
{
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public List<Person> find(String sql)
    {
        String hql = "from Person where id=2 ";
        hql += sql;
        Query q = this.getSession().createQuery(hql);
        return q.setFirstResult(0).setMaxResults(10).list();
        // return q.list();
    }

    public void addPerson(Person person)
    {
        this.getSession().save(person);
    }

    public void deletePersonById(int id)
    {
        this.getSession().createQuery("delete Person where id=?").setParameter(0, id).executeUpdate();
    }

    public void updatePerson(Person person)
    {
        this.getSession().update(person);
    }

    public Person getPersonById(int id)
    {
        return (Person)this.getSession().get(Person.class, id);
    }

    public Person getPersonByName(String name)
    {
        return (Person)this.getSession().createQuery("from Person where name=?").setParameter(0, name).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons()
    {
        return this.getSession().createCriteria(Person.class).list();
    }
}
