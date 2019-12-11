package ro.sda.webdata.persistence.person;

import javax.persistence.*;

//entity sunt clase simple
//tin doar date care pot fi salvate intr o baza de date
//spring sa stie ca o clasa este o entitate, trb adnotarea :
@Entity
@Table(name="person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //unic pt fiecare rand din tabela

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
