package ro.sda.webdata.persistence.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ca spring sa stie de interfata asta trb sa adaugam
@Repository
public interface PersonRepository  extends JpaRepository<PersonEntity,Long> {

    //SELECT * FROM  person WHERE name= ?name

    PersonEntity findByName(String name);

    //SELECT * FROM  person WHERE name= ?name AND id = ?id

    PersonEntity findByNameAndId(String name, Long id);

    //SELECT COUNT(*) FROM person WHERE name =?name

    int findCountByName(String name);



}
