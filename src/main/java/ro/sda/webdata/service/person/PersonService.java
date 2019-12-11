package ro.sda.webdata.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.webdata.persistence.person.PersonEntity;
import ro.sda.webdata.persistence.person.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    //queryurile se fac in tranzactii
    //spring are adnotarea
    //daca toate query-urile s-au executat cu succes, scrie tot in baza de date
    //daca o singura metoda nu a fost cu succes, anuleaza tot. Toate tranzactiile stiu una de cealalta
    @Transactional
    public void save(String name){
        PersonEntity entity = new PersonEntity();
        entity.setName(name);
        personRepository.save(entity);
    }

    @Transactional
    public List<PersonEntity> findAll(){
        return personRepository.findAll();
    }
}
