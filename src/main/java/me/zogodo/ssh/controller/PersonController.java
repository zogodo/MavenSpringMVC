package me.zogodo.ssh.controller;

import org.codehaus.jackson.map.ObjectMapper;

import me.zogodo.ssh.entity.Person;
import me.zogodo.ssh.service.PersonService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes(value = "username")
@Controller
@RequestMapping(value = "/person")
public class PersonController
{
    @Autowired
    public PersonService personService;

    @RequestMapping(value = "/main")
    public String mian(Map<String, Object> map)
    {
        map.put("personlist", personService.getPersons());
        return "main";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveperson(HttpServletResponse response, Person person) throws IOException
    {
        response.setContentType("text/html;charset=utf-8");
        personService.addPerson(person);
        response.getWriter().print("添加成功");
    }

    @RequestMapping(value = "/delete")
    public void deletePersonById(HttpServletResponse response,
                                 @RequestParam(value = "id") int id) throws IOException
    {
        response.setContentType("text/html;charset=utf-8");
        personService.deletePersonById(id);
        response.getWriter().print("删除成功");
    }

    @RequestMapping(value = "/{id}")
    public void one(HttpServletResponse response,  @PathVariable("id") int id) throws IOException
    {
        response.setContentType("text/html;charset=utf-8");
        Person person = personService.getPersonById(id);
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = mapperObj.writeValueAsString(person);
        //System.out.println(jsonStr);
        response.getWriter().print(jsonStr);
    }

    @RequestMapping(value = "/all")
    public void list(HttpServletResponse response) throws IOException
    {
        List<Person> personlist = personService.getPersons();
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = mapperObj.writeValueAsString(personlist);
        //System.out.println(jsonStr);
        response.getWriter().print(jsonStr);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public void test(Map<String, Object> map, HttpServletResponse response, @RequestParam(value = "sql") String sql) throws IOException
    {
        List<Person> lst = personService.find(sql);
        map.put("lst", lst);
    }
}
