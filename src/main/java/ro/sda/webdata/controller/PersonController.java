package ro.sda.webdata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.sda.webdata.persistence.person.PersonEntity;
import ro.sda.webdata.service.person.PersonService;

import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    @PostMapping("save")
    @ResponseBody
    public String save(@RequestBody String name){
        personService.save(name);
        return "saved";

    }

    @GetMapping("all")
    @ResponseBody //nu mai cauta dupa fisiere, cauta direct stringu
    public String findAll(){
        List<PersonEntity> persons = personService.findAll();
        StringJoiner joiner = new StringJoiner(",");
        for(PersonEntity person : persons){
            joiner.add(person.getName());
        }
        return  joiner.toString();
    }
}
