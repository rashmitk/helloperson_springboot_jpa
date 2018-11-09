package com.rashmit.poc.person.controller;

import com.rashmit.poc.person.model.Person;
import com.rashmit.poc.person.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger("JCG");

    @Value("${env.DBURL:null}")
    String dbURL1;

    @Value("${DBURL:null}")
    String dbURL2;

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/echo", method = RequestMethod.GET)
    public String echo() {
        String echo ="<h1>Person Service running successfully...</h1>";
        return echo;
    }

    @RequestMapping(value = "/echoenv", method = RequestMethod.GET)
    public String echoEnv() {
        String echo ="<h1>Echo Service executed successfully....<br/><br/><h3>";

        System.out.println("dbURL1:"+dbURL1+", dbURL2:"+dbURL2);

        String dburl = System.getenv("DBURL");
        System.out.println("dburl :"+dburl);

        String profile_dburl = System.getenv("spring.datasource.url");
        System.out.println("profile_dburl :"+dburl);

        return echo.concat("dbURL1:"+dbURL1+", dbURL2:"+dbURL2);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> listPerson() {
        LOG.info("List of Persons");
        System.out.println("List of persons");
        List<Person> personList = service.getAllPersons();
        LOG.info("List of Persons : {}", personList);
        return personList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@RequestBody Person p) {
        LOG.info("Creation of Persons");
        Person person = service.createPerson(p);
        LOG.info("Person created in DB : {}", person);
        return "Person created successfully";
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updatePerson(@RequestBody Person p) {
        LOG.info("Update of Persons");
        Person editedPerson = service.editPerson(p);
        LOG.info("Person updated in DB : {}", p);
        return "Person updated successfully";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deletePerson(@RequestBody Person p) {
        LOG.info("Delete of Persons");
        service.deletePerson(p);
        LOG.info("After deletion, count: {}", service.countPersons());
        return "Person deleted successfully";
    }


}
